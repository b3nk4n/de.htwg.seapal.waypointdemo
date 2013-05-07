package de.htwg.seapal.waypoint.app;

import com.google.inject.AbstractModule;

import de.htwg.seapal.waypoint.controllers.IWaypointController;
import de.htwg.seapal.waypoint.controllers.mock.WaypointController;
import de.htwg.seapal.waypoint.models.IWaypoint;
import de.htwg.seapal.waypoint.models.mock.Waypoint;

/**
 * Injects the waypoint dependencies using the mocks.
 * @author Felix
 *
 */
public class WaypointMockModule extends WaypointBaseModule {

	@Override
	protected void configure() {
		super.configure();
		
		bind(IWaypoint.class).to(Waypoint.class);
		bind(IWaypointController.class).to(WaypointController.class);
	}
}
