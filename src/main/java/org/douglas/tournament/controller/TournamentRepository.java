package org.douglas.tournament.controller;

import java.util.Date;
import java.util.Set;

import org.douglas.tournament.domain.Tournament;
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
}
