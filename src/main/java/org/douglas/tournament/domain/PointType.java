package org.douglas.tournament.domain;

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
public class PointType {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;

	  @OneToMany(mappedBy = "pointType", cascade = { CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = true)
	  private List<Point> points;
	  
	  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, optional = false)
	  @JoinColumn(name = "sport_id")
	  private Sport sport;

	  private String name;
	  private Long value;

	  public Long getId() {
	    return id;
	  }

	  public String getName() {
	    return name;
	  }
	  public void setName(String name) {
	    this.name = name;
	  }

	  public Long getValue() {
	    return value;
	  }
	  public void setValue(Long value) {
	    this.value = value;
	  }

	  public List<Point> getPoints() {
	    return points;
	  }
	  public void setPoints(List<Point> points) {
	    this.points = points;
	  }

	  public Sport getSport() {
	    return sport;
	  }
	  public void setSport(Sport sport) {
	    this.sport = sport;
	  }
	  
	  PointType(){ // JPA Only
	  }
}
