package de.htwg.seapal.waypoint.models.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import de.htwg.seapal.waypoint.models.IWaypoint;

@RunWith(value = Parameterized.class)
public class SetPositionParamTest {
	
	@Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] {
			   { "0°E 0°N" , "0°E 0°N" },
			   { "0°0'E 0°0'N", "0°0'E 0°0'N" },
			   { "0°0'0\"E 0°0'0\"N" , "0°0'0\"E 0°0'0\"N" },
			   { "0°0'0\"E 0°0'0\"S" , "0°0'0\"E 0°0'0\"S" },
			   { "0°0'0\"W 0°0'0\"N" , "0°0'0\"W 0°0'0\"N" },
			   { "0°0'0\"W 0°0'0\"S" , "0°0'0\"W 0°0'0\"S" },
			   { "0°0'0\"E 10°0'0\"N" , "0°0'0\"E 10°0'0\"N" },
			   { "0°0'0\"E 90°0'0\"N" , "0°0'0\"E 90°0'0\"N" },
			   { "0°0'0\"E 09°0'0\"N" , "0°0'0\"E 09°0'0\"N" },
			   { "0°0'0\"E 9°0'0\"N" , "0°0'0\"E 9°0'0\"N" },
			   { "10°0'0\"E 0°0'0\"N" , "10°0'0\"E 0°0'0\"N" },
			   { "90°0'0\"E 0°0'0\"N" , "90°0'0\"E 0°0'0\"N" },
			   { "090°0'0\"E 0°0'0\"N" , "090°0'0\"E 0°0'0\"N" },
			   { "100°0'0\"E 0°0'0\"N" , "100°0'0\"E 0°0'0\"N" },
			   { "180°0'0\"E 0°0'0\"N" , "180°0'0\"E 0°0'0\"N" },
			   { "151°0'0\"E 0°0'0\"N" , "151°0'0\"E 0°0'0\"N" },
			   { "100°99'0\"E 0°0'0\"N" , "100°99'0\"E 0°0'0\"N" },
			   { "100°0'99\"E 0°0'0\"N" , "100°0'99\"E 0°0'0\"N" }
	   };
	   return Arrays.asList(data);
	 }
	 
	 private String input, output;
     private IWaypoint waypoint;
	 
	 public SetPositionParamTest(String input, String output) {
		    this.input = input;
		    this.output = output;
			waypoint = new Waypoint();
		 }

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		waypoint.setPosition(input);
		assertEquals(output, waypoint.getPosition());
	}

}
