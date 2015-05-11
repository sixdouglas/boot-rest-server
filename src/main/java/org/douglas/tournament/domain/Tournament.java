package org.douglas.tournament.domain;

import java.util.Date;
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
public class Tournament {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private Date tournamentDate;

  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "town_id")
  private Town town;

  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "sport_id")
  private Sport sport;

  @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Match> matches;

  public Long getId() {
    return id;
  }

  public Town getTown() {
    return town;
  }

  public void setTown(Town town) {
    this.town = town;
  }

  public Sport getSport() {
    return sport;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

  public List<Match> getMatches() {
    return matches;
  }

  public void setMatches(List<Match> matches) {
    this.matches = matches;
  }

  Tournament() { // JPA Only
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getTournamentDate() {
    return tournamentDate;
  }

  public void setTournamentDate(Date tournamentDate) {
    this.tournamentDate = tournamentDate;
  }
}
