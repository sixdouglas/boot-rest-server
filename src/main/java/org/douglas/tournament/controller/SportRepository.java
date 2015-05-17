package org.douglas.tournament.controller;

import java.util.List;

import org.douglas.tournament.domain.Sport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sport", path = "sport")
public interface SportRepository extends CrudRepository<Sport, Long> {

  List<Sport> findByName(@Param("name") String name);

  List<Sport> findByNameStartingWithIgnoreCase(@Param("name") String name);
}
