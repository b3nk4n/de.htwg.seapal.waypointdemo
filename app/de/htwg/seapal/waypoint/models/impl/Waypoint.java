package de.htwg.seapal.waypoint.models.impl;

import de.htwg.seapal.waypoint.models.AbstractWaypoint;
import de.htwg.seapal.waypoint.models.IWaypoint;

/**
 * The implementation of a Waypoint
 * @author Felix
 *
 */
public final class Waypoint extends AbstractWaypoint {

	/**
	 * Creates a new waypoint instance.
	 */
	public Waypoint() {
	}

	/**
	 * Creates a copy of the given waypoint.
	 * @param waypoint
	 */
	public Waypoint(final IWaypoint waypoint) {
		super(waypoint);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Waypoint(this);
	}

}
