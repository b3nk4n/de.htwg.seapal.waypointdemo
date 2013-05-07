package de.htwg.seapal.waypoint.models.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.seapal.waypoint.models.IWaypoint;
import de.htwg.seapal.waypoint.models.IWaypoint.ForeSail;
import de.htwg.seapal.waypoint.models.IWaypoint.MainSail;
import de.htwg.seapal.waypoint.models.IWaypoint.Maneuver;

public class WaypointTest {

	private IWaypoint waypoint;
	
	@Before
	public void setUp() throws Exception {
		waypoint = new Waypoint();
	}

	@Test
	public void testName() {
		waypoint.setName("Waypoint 1");
		assertEquals("Waypoint 1", waypoint.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNameEmpty() {
			waypoint.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNameNull() {
			waypoint.setName(null);
	}


	@Test
	public void testPosition() {
		waypoint.setPosition("0°12'12\"E 47°12'12\"N");
		assertEquals("0°12'12\"E 47°12'12\"N", waypoint.getPosition());
		

		waypoint.setPosition("0°12'E 47°12'N");
		assertEquals("0°12'E 47°12'N", waypoint.getPosition());
		

		waypoint.setPosition("0°E 47°N");
		assertEquals("0°E 47°N", waypoint.getPosition());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPositionWrong() {
		waypoint.setPosition("0°12'12\"E ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPositionNull() {
		waypoint.setPosition(null);
	}

	@Test
	public void testNote() {
	}

	@Test
	public void testBTM() {
	}

	@Test
	public void testDTM() {
	}

	@Test
	public void testCOG() {
	}
	@Test
	public void testSOG() {
	}
	
	//FIXME use a correct mark
	@Test
	public void testMark() {
	}

	
	@Test
	public void testForesail() {
		waypoint.setForesail(ForeSail.FOCK);
		assertEquals(ForeSail.FOCK, waypoint.getForesail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testForesailNull() {
		waypoint.setForesail(null);
	}

	@Test
	public void testMainsail() {
		waypoint.setMainsail(MainSail.FULL);
		assertEquals(MainSail.FULL, waypoint.getMainsail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMainsailNull() {
		waypoint.setMainsail(null);
	}
	

	@Test
	public void testManeuver() {
		waypoint.setManeuver(Maneuver.ANKER_DOWN);
		assertEquals(Maneuver.ANKER_DOWN, waypoint.getManeuver());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testManeuverNull() {
		waypoint.setManeuver(null);
	}

	@Test
	public void testToString() {
		//assertEquals("{name=MyWaypoint; pos=0°12'12\"E 47°12'12\"N; note=Here is a note; " +
		//		"btm=0; dtm=0; cog=0; sog=0; man=ANKER_DOWN; fsail=NONE; msail=REEF1; mark=null}",
		//		waypoint.toString());
	}
	


}
