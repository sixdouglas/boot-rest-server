package org.douglas.tournament.controller;

import java.util.List;

import org.douglas.tournament.domain.PointType;
import org.douglas.tournament.domain.Town;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pointType", path = "pointType")
public interface PointTypeRepository extends PagingAndSortingRepository<PointType, Long> {
	  List<PointType> findByNameStartingWithIgnoreCase(@Param("name") String name);
	  
	  @Query(value = "	SELECT P "
				+ "	FROM PointType P JOIN P.sport S "
				+ " WHERE ( :sport     IS NOT NULL "
				+ " 	AND :pointType IS NOT NULL "
				+ " 	AND LOWER(S.name) LIKE LOWER(CONCAT(:sport, '%')) "
				+ " 	AND LOWER(P.name) LIKE LOWER(CONCAT(:pointType, '%'))) "
				+ " OR (    :sport     IS NULL "
				+ " 	AND :pointType IS NOT NULL "
				+ " 	AND LOWER(P.name) like LOWER(CONCAT(:pointType, '%'))) "
				+ " OR (    :sport     IS NOT NULL "
				+ " 	AND :pointType IS NULL "
				+ " 	AND LOWER(S.name) LIKE LOWER(CONCAT(:sport, '%')))")
	  List<Town> findByNamesStartingWithIgnoreCase(@Param("pointType") String name, @Param("sport") String sportName);
}
