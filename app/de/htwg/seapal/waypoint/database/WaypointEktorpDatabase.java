package de.htwg.seapal.waypoint.database;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.ViewQuery;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import de.htwg.seapal.waypoint.models.IWaypoint;
import de.htwg.seapal.waypoint.models.impl.Waypoint;

public class WaypointEktorpDatabase implements IWaypointDatabase {

	CouchDbInstance dbInstance;
	CouchDbConnector db;
	
	@Override
	public void open(String database) {
		try {
			dbInstance = new StdCouchDbInstance(new StdHttpClient.Builder()
				.url("http://roroettg.iriscouch.com")
				.build());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (database == null) {
			database = "seapal_waypoint_db";
		}
		db = dbInstance.createConnector(database, true);
	}

	@Override
	public void close() {

	}

	@Override
	public Map<String, IWaypoint> loadWaypoints() {
		ViewQuery query = new ViewQuery().allDocs();
		List<IWaypoint> result = db.queryView(query, IWaypoint.class);
		Map<String, IWaypoint> waypoints = new HashMap<String, IWaypoint>();
		
		for (IWaypoint waypoint : result) {
			waypoints.put(waypoint.getId(), waypoint);
		}
		
		return waypoints;
	}

	@Override
	public Map<String, IWaypoint> loadWaypoints(int limit) {
		ViewQuery query = new ViewQuery().allDocs();
		List<IWaypoint> result = db.queryView(query, IWaypoint.class);
		Map<String, IWaypoint> waypoints = new HashMap<String, IWaypoint>();
	
		for (int i = 0; i < result.size() && i < limit; ++i) {
			waypoints.put(result.get(i).getId(), result.get(i));
		}

		return waypoints;
	}

	@Override
	public IWaypoint getWaypointById(String waypointId) {
		IWaypoint waypoint = db.get(Waypoint.class, waypointId);

		return waypoint;
	}

	@Override
	public boolean insertWaypoint(IWaypoint waypoint) {
		db.create(waypoint);
		return true;
	}

	@Override
	public boolean updateWaypoint(IWaypoint waypoint) {
		db.update(waypoint);
		return true;
	}

	@Override
	public boolean deleteWaypoint(IWaypoint waypoint) {
		db.delete(waypoint);
		return true;
	}
	
	public static void main(String[] args) {
		IWaypointDatabase database = new WaypointEktorpDatabase();
		database.open("seapal_waypoint_db");
		
		insertWaypoint(database);
		
		Map<String, IWaypoint> wps = getAllWaypoints(database);
		System.out.println(wps.size());
	}
	
	private static void insertWaypoint(IWaypointDatabase database) {
		IWaypoint wp = new Waypoint();
		wp.setName("Testwaypoint");
		
		database.insertWaypoint(wp);
	}
	
	private static Map<String,IWaypoint> getAllWaypoints(IWaypointDatabase database) {
		return database.loadWaypoints();
	}
}
