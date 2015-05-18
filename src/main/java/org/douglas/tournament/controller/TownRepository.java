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
  
  @Query(value = "	SELECT * "
  				+ "	FROM TOWN INNER JOIN COUNTRY ON "
  				+ "		(TOWN.COUNTRY_ID = COUNTRY.ID) "
  				+ " WHERE (:country IS NOT NULL "
  				+ " 	AND :town IS NOT NULL"
  				+ " 	AND LOWER(COUNTRY.NAME) LIKE LOWER(CONCAT(:country, '%')) "
  				+ " 	AND LOWER(TOWN.NAME) like LOWER(CONCAT(:town, '%'))) "
  				+ " OR (:country IS NULL "
  				+ " 	AND :town IS NOT NULL"
  				+ " 	AND LOWER(TOWN.NAME) like LOWER(CONCAT(:town, '%'))) "
  				+ " OR (:country IS NOT NULL "
  				+ " 	AND :town IS NULL"
  				+ " 	AND LOWER(COUNTRY.NAME) LIKE LOWER(CONCAT(:country, '%')))", nativeQuery = true)
  List<Town> findByNamesStartingWithIgnoreCase(@Param("town") String name, @Param("country") String countryName);
}
