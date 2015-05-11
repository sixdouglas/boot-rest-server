package org.douglas.tournament.controller;

import org.douglas.tournament.domain.Match;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "match", path = "match")
public interface MatchRepository extends PagingAndSortingRepository<Match, Long> {

}
