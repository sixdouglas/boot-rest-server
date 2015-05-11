package org.douglas.tournament.controller;

import java.util.List;

import org.douglas.tournament.domain.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "team", path = "team")
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {

	List<Team> findByName(@Param("name") String name);
}
