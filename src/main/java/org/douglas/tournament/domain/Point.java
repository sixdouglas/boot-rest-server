package org.douglas.tournament.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "match_id")
	private Match match;

	@Enumerated(EnumType.STRING)
	private TypePoint typePoint;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "team_id")
	private Team team;

	private Date dateTime;

	public Long getId() {
		return id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public TypePoint getTypePoint() {
		return typePoint;
	}

	public void setTypePoint(TypePoint typePoint) {
		this.typePoint = typePoint;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	Point() { // JPA Only
	}
}
