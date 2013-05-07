package de.htwg.seapal.waypoint.controller;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.htwg.seapal.waypoint.controllers.IWaypointController;
import de.htwg.seapal.waypoint.controllers.impl.WaypointController;
import de.htwg.seapal.waypoint.models.IWaypoint.ForeSail;
import de.htwg.seapal.waypoint.models.IWaypoint.MainSail;
import de.htwg.seapal.waypoint.models.IWaypoint.Maneuver;
import de.htwg.seapal.waypoint.models.mock.Waypoint;

public class ControllerTest {

	private IWaypointController controller;

	@Before
	public void setUp() {
		controller = new WaypointController(new Waypoint());
	}

	@After
	public void tearDown() {
		controller.tearDown();
	}

	@Test
	public void testGetName() {
		assertEquals("MyWaypoint", controller.getName());
	}

	@Test
	public void testGetPosition() {
		assertEquals("0°12'12\"E 47°12'12\"N", controller.getPosition());
	}

	@Test
	public void testGetNote() {
		assertEquals("Here is a note", controller.getNote());
	}

	@Test
	public void testGetBTM() {
		assertEquals(0, controller.getBTM());
	}

	@Test
	public void testGetDTM() {
		assertEquals(0, controller.getDTM());
	}

	@Test
	public void testGetCOG() {
		assertEquals(0, controller.getCOG());
	}
	@Test
	public void testGetSOG() {
		assertEquals(0, controller.getSOG());
	}

	//FIXME use a correct mark
	@Test
	public void testGetMark() {
		assertEquals(null, controller.getMark());
	}

	@Test
	public void testGetForesail() {
		assertEquals(ForeSail.NONE, controller.getForesail());
	}


	@Test
	public void testGetMainsail() {
		assertEquals(MainSail.REEF1, controller.getMainsail());
	}


	@Test
	public void testGetManeuver() {
		assertEquals(Maneuver.ANKER_DOWN, controller.getManeuver());
	}

	@Test
	public void testToString() {
		assertEquals("Waypoint:{id=w1; name=MyWaypoint; pos=0°12'12\"E 47°12'12\"N; note=Here is a note; " +
				"btm=0; dtm=0; cog=0; sog=0; man=ANKER_DOWN; fsail=NONE; msail=REEF1; mark=null}",
				controller.getString());
	}

}
