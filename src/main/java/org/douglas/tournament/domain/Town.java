package org.douglas.tournament.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Town {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String postalCode;

  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "country_id")
  private Country country;

  @OneToMany(mappedBy = "town", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Team> teams;

  @JsonIgnore
  @OneToMany(mappedBy = "town", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Tournament> tournaments;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public List<Team> getTeams() {
    return teams;
  }

  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

  public List<Tournament> getTournaments() {
    return tournaments;
  }

  public void setTournaments(List<Tournament> tournaments) {
    this.tournaments = tournaments;
  }

  Town() { // JPA Only
  }
}
