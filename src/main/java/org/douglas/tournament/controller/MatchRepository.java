package org.douglas.tournament.controller;

import java.util.Date;
import java.util.Set;

import org.douglas.tournament.domain.Match;
import org.douglas.tournament.domain.Tournament;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "match", path = "match")
public interface MatchRepository extends PagingAndSortingRepository<Match, Long> {
	
	Set<Tournament> findByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
