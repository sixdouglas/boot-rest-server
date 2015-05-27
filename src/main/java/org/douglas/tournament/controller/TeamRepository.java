package org.douglas.tournament.controller;

import java.util.List;

import org.douglas.tournament.domain.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "team", path = "team")
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {

	List<Team> findByName(@Param("name") String name);
//	List<Team> findByNameStartingWithIgnoreCase(@Param("name") String name);
	  @Query(value = "	SELECT T "
				+ "	FROM Team T JOIN T.town To "
				+ " WHERE ( :team   IS NOT NULL "
				+ " 	AND :age	IS NOT NULL "
				+ " 	AND :town	IS NOT NULL "
				+ " 	AND LOWER(T.name)  LIKE LOWER(CONCAT(:team, '%')) "
				+ " 	AND LOWER(T.age)   LIKE LOWER(CONCAT(:age, '%')) "
				+ " 	AND LOWER(To.name) LIKE LOWER(CONCAT(:town, '%'))) "
				+ " OR (    :team   IS NOT NULL "
				+ " 	AND :age    IS NULL "
				+ " 	AND :town   IS NULL "
				+ " 	AND LOWER(T.name) LIKE LOWER(CONCAT(:team, '%'))) "
				+ " OR (    :team   IS NULL "
				+ " 	AND :age    IS NOT NULL "
				+ " 	AND :town   IS NULL "
				+ " 	AND LOWER(T.age) LIKE LOWER(CONCAT(:age, '%'))) "
				+ " OR (    :team   IS NULL "
				+ " 	AND :age    IS NULL "
				+ " 	AND :town   IS NOT NULL "
				+ " 	AND LOWER(To.name) LIKE LOWER(CONCAT(:town, '%')))"
				+ " OR (    :team   IS NOT NULL "
				+ " 	AND :age    IS NOT NULL "
				+ " 	AND :town   IS NULL "
				+ " 	AND LOWER(T.name) LIKE LOWER(CONCAT(:team, '%')) "
				+ " 	AND LOWER(T.age)  LIKE LOWER(CONCAT(:age, '%'))) "
				+ " OR (    :team   IS NULL "
				+ " 	AND :age    IS NOT NULL "
				+ " 	AND :town   IS NOT NULL "
				+ " 	AND LOWER(T.age)   LIKE LOWER(CONCAT(:age, '%')) "
				+ " 	AND LOWER(To.name) LIKE LOWER(CONCAT(:town, '%'))) "
				+ " OR (    :team   IS NOT NULL "
				+ " 	AND :age    IS NULL "
				+ " 	AND :town   IS NOT NULL "
				+ " 	AND LOWER(T.name)  LIKE LOWER(CONCAT(:team, '%')) "
				+ " 	AND LOWER(To.name) LIKE LOWER(CONCAT(:town, '%'))) "
				)
	List<Team> findByNamesStartingWithIgnoreCase(@Param("team") String name, @Param("age") String age, @Param("town") String town);
}
