package de.htwg.seapal.waypoint.controllers;


import java.util.List;
import java.util.NoSuchElementException;

import de.htwg.seapal.mark.models.IMark;
import de.htwg.seapal.waypoint.models.IWaypoint;
import de.htwg.seapal.waypoint.models.IWaypoint.ForeSail;
import de.htwg.seapal.waypoint.models.IWaypoint.MainSail;
import de.htwg.seapal.waypoint.models.IWaypoint.Maneuver;
import de.htwg.util.observer.IObservable;

/**
 * Represents a waypoint.
 * @author Felix
 *
 */
public interface IWaypointController extends IObservable {

	/**
	 * Returns the name of the waypoint.
	 * @return the name
	 */
	String getName();

	/**
	 * Returns the position as string of the waypoint.
	 * @return the position.
	 */
	String getPosition();

	/**
	 * Returns the Note of the waypoint.
	 * @return the note or an empty String.
	 */
	String getNote();

	/**
	 * Returns the Baring To Mark value.
	 * @return baring to mark in degrees.
	 */
	int getBTM();

	/**
	 * Returns the Distance To Mark value.
	 * @return distance to mark.
	 */
	int getDTM();

	/**
	 * Returns the Course Over Ground value.
	 * @return course over ground in degrees.
	 */
	int getCOG();

	/**
	 * Returns the Speed Over Ground value.
	 * @return speed over ground.
	 */
	int getSOG();

	/**
	 * Returns the mark.
	 * @return the mark
	 */
	IMark getMark();

	/**
	 * Returns the maneuver done at the waypoint.
	 * @return the maneuver
	 */
	Maneuver getManeuver();

	/**
	 * Returns the foresail set at the waypoint.
	 * @return the foresail
	 */
	ForeSail getForesail();

	/**
	 * Returns the main sail set at the waypoint.
	 * @return the main sail
	 */
	MainSail getMainsail();


	/**
	 * Sets the name.
	 * @param name the name
	 */
	void setName(String name);

	/**
	 * Sets the position.
	 * @param position the position
	 */
	void setPosition(String position);

	/**
	 * Sets the note.
	 * @param note the note
	 */
	void setNote(String note);

	/**
	 * Sets the Baring To Mark in degrees.
	 * @param btm Baring To Mark
	 */
	void setBTM(int btm);

	/**
	 * Sets the Distance To Mark.
	 * @param dtm Distance To Mark
	 */
	void setDTM(int dtm);

	/**
	 * Sets the Course Over Ground in degrees.
	 * @param cog Course Over Ground
	 */
	void setCOG(int cog);

	/**
	 * Sets the Speed Over Ground.
	 * @param sog Speed Over Ground
	 */
	void setSOG(int sog);

	/**
	 * Sets the mark representing through its id.
	 * @param markId id of mark
	 * @throws NoSuchElementException if there is no Mark to the id
	 */
	void setMark(String markId);

	/**
	 * Sets the maneuver of the waypoint.
	 * Don't use <tt>null</tt> here. Use <tt>Maneuver.NONE</tt> instead.
	 * @param maneuver the maneuver
	 * @throws IllegalArgumentException if mainSail is null
	 */
	void setManeuver(Maneuver maneuver);

	/**
	 * Sets the main sail.<br/>
	 * Don't use <tt>null</tt> here. Use <tt>Mainsail.NONE</tt> instead.
	 * @param mainSail the mainsail
	 * @throws IllegalArgumentException if mainSail is null
	 */
	void setMainsail(MainSail mainSail);

	/**
	 * Sets the fore sail.<br/>
	 * Don't use <tt>null</tt> here. Use <tt>Foresail.NONE</tt> instead.
	 * @param foreSail the foresail
	 * @throws IllegalArgumentException if foreSail is null
	 */
	void setForesail(ForeSail foreSail);

	/**
	 * Returns the string representing the current modifying waypoint.
	 * @return string representing the current modifying waypoint
	 */
	String getString();

	/**
	 * Creates a new WaypointElement.
	 */
	void createNewWaypoint();

	/**
	 * Selects the waypoint representing by the id.
	 * @param id id of waypoint
	 */
	void updateWaypoint(String id);


	/**
	 * Delete the currently selected waypoint.
	 */
	void deleteWaypoint();

	/**
	 * Saves the changes to the currently selected waypoint.
	 */
	void saveWaypoint();

	/**
	 * Gets a list of all waypoints.
	 */
	List<IWaypoint> getWaypoints();

	/**
	 * Closes database connection and other open resources.
	 */
	void tearDown();
}
