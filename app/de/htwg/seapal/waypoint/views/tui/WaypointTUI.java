package de.htwg.seapal.waypoint.views.tui;

import static java.lang.System.out;

import java.util.Scanner;

import com.google.inject.Inject;

import de.htwg.seapal.mark.views.tui.MarkTUI;
import de.htwg.seapal.waypoint.controllers.IWaypointController;
import de.htwg.seapal.waypoint.models.IWaypoint;
import de.htwg.seapal.waypoint.models.IWaypoint.ForeSail;
import de.htwg.seapal.waypoint.models.IWaypoint.MainSail;
import de.htwg.seapal.waypoint.models.IWaypoint.Maneuver;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;
import de.htwg.util.plugin.Plugin;

public class WaypointTUI implements IObserver, Plugin {

	private final IWaypointController controller;
	// TODO: Reference to IMark
	private MarkTUI markTUI;

	@Inject
	public WaypointTUI(final IWaypointController controller) {
		this.controller = controller;
		this.controller.addObserver(this);
	}

	@Override
	public void update(final Event e) {
		printTUI();
	}

	@Override
	public boolean processInputLine(final String line) {

		Scanner scanner = new Scanner(line);
		scanner.useDelimiter(" ");
		String input = scanner.next();
		boolean continu = true;
		if (input.equalsIgnoreCase("q")) {
			continu = false;
			controller.tearDown();
		}
		if (input.equalsIgnoreCase("name")) {
			controller.setName(scanner.next());
		}
		if (input.equalsIgnoreCase("pos")) {
			controller.setPosition(scanner.next());
		}
		if (input.equalsIgnoreCase("note")) {
			controller.setNote(scanner.next());
		}
		if (input.equalsIgnoreCase("btm")) {
			controller.setBTM(scanner.nextInt());
		}
		if (input.equalsIgnoreCase("dtm")) {
			controller.setDTM(scanner.nextInt());
		}
		if (input.equalsIgnoreCase("cog")) {
			controller.setCOG(scanner.nextInt());
		}
		if (input.equalsIgnoreCase("sog")) {
			controller.setSOG(scanner.nextInt());
		}
		if (input.equalsIgnoreCase("man")) {
			controller.setManeuver(Maneuver.valueOf(scanner.next()));
		}
		if (input.equalsIgnoreCase("fsail")) {
			controller.setForesail(ForeSail.valueOf(scanner.next()));
		}
		if (input.equalsIgnoreCase("msail")) {
			controller.setMainsail(MainSail.valueOf(scanner.next()));
		}
		if (input.equalsIgnoreCase("mark")) {
			//			TODO: Übergabe testen, Absprache bezgl. Params
			markTUI.processInputLine(controller.getMark().toString());
		}
		if (input.equalsIgnoreCase("create")) {
			controller.createNewWaypoint();
		}
		if (input.equalsIgnoreCase("save")) {
			controller.saveWaypoint();
		}
		if (input.equalsIgnoreCase("delete")) {
			controller.deleteWaypoint();
		}
		if (input.equalsIgnoreCase("select")) {
			controller.updateWaypoint(scanner.next());
		}
		if (input.equalsIgnoreCase("show")) {
			for (IWaypoint iWaypoint : controller.getWaypoints()) {
				System.out.println(iWaypoint);
			}
			printTUI();
		}
		scanner.close();
		return continu;
	}

	@Override
	public void printTUI() {
		out.println(controller.getString());
		out.println("WaypointDemo:\n" +
				"\t\t create - creates new waypoint\n" +
				"\t\t save   - saves all changes\n" +
				"\t\t delete - deletes the current waypoint\n" +
				"\t\t select - selects an waypoint by its id\n\n" +
				"\t\t show   - print out all stored waypoints\n\n" +
				"\t\t pos    - set position\n" +
				"\t\t note   - set note\n" +
				"\t\t btm    - set bare to mark\n" +
				"\t\t dtm    - set distance to mark\n" +
				"\t\t cog    - set course over ground\n" +
				"\t\t sog    - set speed over ground\n" +
				"\t\t man    - set maneuver\n" +
				"\t\t fsail  - set foresail\n" +
				"\t\t msail  - set mainsail\n" +
				"\t\t mark   - set mark\n" +
				"\t\t q - quit");
		out.print(">>");

	}

	@Override
	public String getMenuEntry() {
		return "Waypoint";
	}

	@Override
	public char getMenuKey() {
		return 'w';
	}
}
