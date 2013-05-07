package de.htwg.seapal.waypoint.models;

import de.htwg.seapal.mark.models.IMark;

public interface IWaypoint extends Cloneable {

	public enum Maneuver {
		NONE, TACK, JIBE, LAYTO, SET_SAILS, CHANGE_SAILS, SAILS_DOWN, REFF, ANKER_UP, ANKER_DOWN
	}

	public enum ForeSail {
		NONE, GENUA1, GENUA2, GENUA3, FOCK, STORM_FOCK, BISTER, SPINACKER
	}

	public enum MainSail {
		NONE, FULL, REEF1, REEF2
	}

	String getName();

	String getPosition();

	String getNote();

	int getBTM();

	int getDTM();

	int getCOG();

	int getSOG();

	IMark getMark();

	Maneuver getManeuver();

	ForeSail getForesail();

	MainSail getMainsail();

	void setForesail(ForeSail foreSail);

	void setName(String name);

	void setPosition(String position);

	void setNote(String note);

	void setBTM(int btm);

	void setDTM(int dtm);

	void setCOG(int cog);

	void setSOG(int sog);

	void setMark(IMark mark);

	void setManeuver(Maneuver maneuver);

	void setMainsail(MainSail mainSail);

	void setId(String id);

	String getId();

	Object clone() throws CloneNotSupportedException;
}