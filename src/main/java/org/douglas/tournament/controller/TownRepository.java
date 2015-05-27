package org.douglas.tournament.controller;

import java.util.List;

import org.douglas.tournament.domain.Town;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "town", path = "town")
public interface TownRepository extends PagingAndSortingRepository<Town, Long> {

  List<Town> findByName(@Param("name") String name);
  List<Town> findByNameStartingWithIgnoreCase(@Param("name") String name);
  
  @Query(value = "	SELECT T "
			+ "	FROM Town T JOIN T.country C "
			+ " WHERE ( :country     IS NOT NULL "
			+ " 	AND :town		 IS NOT NULL "
			+ " 	AND LOWER(C.name) LIKE LOWER(CONCAT(:country, '%')) "
			+ " 	AND LOWER(T.name) LIKE LOWER(CONCAT(:town, '%'))) "
			+ " OR (    :country     IS NULL "
			+ " 	AND :town 		 IS NOT NULL "
			+ " 	AND LOWER(T.name) like LOWER(CONCAT(:town, '%'))) "
			+ " OR (    :country     IS NOT NULL "
			+ " 	AND :town 		 IS NULL "
			+ " 	AND LOWER(C.name) LIKE LOWER(CONCAT(:country, '%')))")
  List<Town> findByNamesStartingWithIgnoreCase(@Param("town") String name, @Param("country") String countryName);
}
