package org.douglas.tournament.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Integer code;
  private String alpha2;
  private String alpha3;
  private String name;

  @OneToMany(mappedBy = "country", cascade = { CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = true)
  private List<Town> towns;

  public Long getId() {
    return id;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getAlpha2() {
    return alpha2;
  }

  public void setAplha2(String alpha2) {
    this.alpha2 = alpha2;
  }

  public String getAlpha3() {
    return alpha3;
  }

  public void setAplha3(String alpha3) {
    this.alpha3 = alpha3;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Town> getTowns() {
    return towns;
  }

  public void setTowns(List<Town> towns) {
    this.towns = towns;
  }

  Country() { // JPA Only
  }

  Country(String name) { // JPA Only
    this.name = name;
  }
}
