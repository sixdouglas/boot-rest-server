package org.douglas.tournament.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.douglas.tournament.domain.Team;
import org.douglas.tournament.domain.Tournament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tournament", path = "tournament")
public interface TournamentRepository extends PagingAndSortingRepository<Tournament, Long> {
	/*
	 * http://localhost:8090/tournament/search/findByTournamentDate?date=2011/06/23
	 */
	Set<Tournament> findByTournamentDate(@Param("date") Date date);
	
	/*
	 * http://localhost:8090/tournament/search/findByTournamentDateBetween?startDate=2011/06/20&endDate=2011/06/28
	 */
	Set<Tournament> findByTournamentDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	  @Query(value = "	SELECT T "
				+ "	FROM Tournament T JOIN T.town To JOIN T.sport S "
				+ " WHERE ( :tournament IS NOT NULL "
				+ " 	AND :sport		IS NOT NULL "
				+ " 	AND :town		IS NOT NULL "
				+ " 	AND LOWER(T.name)  LIKE LOWER(CONCAT(:tournament, '%')) "
				+ " 	AND LOWER(S.name)  LIKE LOWER(CONCAT(:sport, '%')) "
				+ " 	AND LOWER(To.name) LIKE LOWER(CONCAT(:town, '%'))) "
				+ " OR (    :tournament IS NOT NULL "
				+ " 	AND :sport		IS NULL "
				+ " 	AND :town		IS NULL "
				+ " 	AND LOWER(T.name) LIKE LOWER(CONCAT(:tournament, '%'))) "
				+ " OR (    :tournament IS NULL "
				+ " 	AND :sport		IS NOT NULL "
				+ " 	AND :town		IS NULL "
				+ " 	AND LOWER(S.name) LIKE LOWER(CONCAT(:sport, '%'))) "
				+ " OR (    :tournament IS NULL "
				+ " 	AND :sport		IS NULL "
				+ " 	AND :town		IS NOT NULL "
				+ " 	AND LOWER(To.name) LIKE LOWER(CONCAT(:town, '%')))"
				+ " OR (    :tournament IS NOT NULL "
				+ " 	AND :sport		IS NOT NULL "
				+ " 	AND :town		IS NULL "
				+ " 	AND LOWER(T.name) LIKE LOWER(CONCAT(:tournament, '%')) "
				+ " 	AND LOWER(S.name) LIKE LOWER(CONCAT(:sport, '%'))) "
				+ " OR (    :tournament IS NULL "
				+ " 	AND :sport		IS NOT NULL "
				+ " 	AND :town		IS NOT NULL "
				+ " 	AND LOWER(S.name)  LIKE LOWER(CONCAT(:sport, '%')) "
				+ " 	AND LOWER(To.name) LIKE LOWER(CONCAT(:town, '%'))) "
				+ " OR (    :tournament IS NOT NULL "
				+ " 	AND :sport    	IS NULL "
				+ " 	AND :town   	IS NOT NULL "
				+ " 	AND LOWER(T.name)  LIKE LOWER(CONCAT(:tournament, '%')) "
				+ " 	AND LOWER(To.name) LIKE LOWER(CONCAT(:town, '%'))) "
				)
	List<Tournament> findByNamesStartingWithIgnoreCase(@Param("tournament") String name, @Param("town") String town, @Param("sport") String sport);
}
