package org.douglas.tournament.controller;

import org.douglas.tournament.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

  List<Country> findByName(@Param("name") String name);
  
  List<Country> findByNameStartingWithIgnoreCase(@Param("name") String name);
}
