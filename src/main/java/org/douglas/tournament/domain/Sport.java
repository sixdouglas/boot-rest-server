package org.douglas.tournament.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sport {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany(mappedBy = "sport", cascade = { CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = true)
  private List<Tournament> tournaments;

  @OneToMany(mappedBy = "sport", cascade = { CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = true)
  private List<PointType> pointTypes;

  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Tournament> getTournaments() {
    return tournaments;
  }

  public void setTournaments(List<Tournament> tournaments) {
    this.tournaments = tournaments;
  }

  public List<PointType> getPointTypes() {
    return pointTypes;
  }

  public void setPointTypes(List<PointType> pointTypes) {
    this.pointTypes = pointTypes;
  }

  Sport() { // JPA Only
  }
}
