package de.htwg.seapal.waypoint.database;

import java.util.Map;

import de.htwg.seapal.waypoint.models.IWaypoint;

/**
 * The Interface for controller of the persistence data flow.
 * @author Felix
 *
 */
public interface IWaypointDatabase {

	/**
	 * Opens the database.
	 * @param database
	 */
	void open(String database);

	/**
	 * Closes the Database.
	 */
	void close();

	/**
	 * Returns all Waypoints in a Mapping id->Waypoint.
	 * @return Mapping of all waypoints
	 */
	Map<String, IWaypoint> loadWaypoints();

	/**
	 * Returns a limited number of Waypoints in a Mapping id->Waypoint.
	 * @param limit the number of waypoints to return
	 * @return Mapping of waypoints
	 */
	Map<String, IWaypoint> loadWaypoints(int limit);

	/**
	 * Returns a specific waypoint represented through the id.
	 * @param waypointId
	 * @return
	 */
	IWaypoint getWaypointById(final String waypointId);

	/**
	 * Inserts a new waypoint into the persistence layer.
	 * @param waypoint the waypoint to be added.
	 * @return <tt>true</tt> on success
	 */
	boolean insertWaypoint(IWaypoint waypoint);

	/**
	 * Updates an existing waypoint to its new values.
	 * @param waypoint the waypoint to be updated.
	 * @return <tt>true</tt> on success
	 */
	boolean updateWaypoint(IWaypoint waypoint);

	/**
	 * Deletes an existing waypoint from the persistence layer.
	 * @param waypoint the waypoint to be deleted.
	 * @return <tt>true</tt> on success
	 */
	boolean deleteWaypoint(IWaypoint waypoint);
}
