package org.douglas.tournament.controller;

import java.util.List;

import org.douglas.tournament.domain.PointType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pointType", path = "pointType")
public interface PointTypeRepository extends PagingAndSortingRepository<PointType, Long> {
	  List<PointType> findByNameStartingWithIgnoreCase(@Param("name") String name);
}
