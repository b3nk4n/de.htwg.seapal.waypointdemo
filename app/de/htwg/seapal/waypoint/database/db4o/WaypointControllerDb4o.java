package de.htwg.seapal.waypoint.database.db4o;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

import de.htwg.seapal.waypoint.database.IWaypointDatabase;
import de.htwg.seapal.waypoint.models.IWaypoint;

public class WaypointControllerDb4o implements IWaypointDatabase {


	private ObjectContainer db;

	public WaypointControllerDb4o() {
	}

	@Override
	public IWaypoint getWaypointById(final String waypointId) {
		List<IWaypoint> waypoints = db.query(new Predicate<IWaypoint>() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean match(final IWaypoint waypoint) {
				return waypoint.getId().equals(waypointId);
			}
		});

		if (waypoints.isEmpty()) {
			return null;
		}
		return waypoints.get(0);
	}

	@Override
	public void open(final String database) {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), database);
	}

	@Override
	public void close() {
		db.close();
	}

	@Override
	public Map<String, IWaypoint> loadWaypoints() {
		List<IWaypoint> list = db.query(IWaypoint.class);
		TreeMap<String, IWaypoint> map = new TreeMap<String, IWaypoint>();
		for (IWaypoint iWaypoint : list) {
			map.put(iWaypoint.getId(), iWaypoint);
		}
		return map;
	}

	@Override
	public Map<String, IWaypoint> loadWaypoints(final int limit) {
		List<IWaypoint> list = db.query(IWaypoint.class);
		TreeMap<String, IWaypoint> map = new TreeMap<String, IWaypoint>();
		int i = 0;
		for (IWaypoint iWaypoint : list) {
			map.put(iWaypoint.getId(), iWaypoint);
			if (++i == limit) {
				break;
			}
		}
		return map;
	}


	//TODO what if waypoint == null
	//TODO what if waypoint (not) stored yet?
	//TODO handle exceptions
	//TODO set returnvalue right

	@Override
	public boolean insertWaypoint(final IWaypoint waypoint) {
		db.store(waypoint);
		return true;
	}

	@Override
	public boolean updateWaypoint(final IWaypoint waypoint) {
		db.store(waypoint);
		return true;
	}

	@Override
	public boolean deleteWaypoint(final IWaypoint waypoint) {
		db.delete(waypoint);
		return true;
	}


}
