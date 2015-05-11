package org.douglas.tournament.domain;

public enum TypePoint {
	RUGBY_TRY(5),
	RUGBY_PENALTY_TRY(5),
	RUGBY_CONVERSION(2),
	RUGBY_PENALTY_GOAL(3),
	RUGBY_DROP_GOAL(3);

	private int points = 0;
	
	private TypePoint(int points){
		this.points = points;
	}
	
	public int getPoints() {
		// TODO Auto-generated method stub
		return points;
	}

}
