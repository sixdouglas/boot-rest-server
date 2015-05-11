package org.douglas.tournament.controller;

import org.douglas.tournament.domain.Town;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "town", path = "town")
public interface TownRepository extends CrudRepository<Town, Long> {

  List<Town> findByName(@Param("name") String name);
}
