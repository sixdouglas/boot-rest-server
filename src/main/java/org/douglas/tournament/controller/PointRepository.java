package org.douglas.tournament.controller;

import java.util.List;

import org.douglas.tournament.domain.Match;
import org.douglas.tournament.domain.Point;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "point", path = "point")
public interface PointRepository extends PagingAndSortingRepository<Point, Long> {
}
