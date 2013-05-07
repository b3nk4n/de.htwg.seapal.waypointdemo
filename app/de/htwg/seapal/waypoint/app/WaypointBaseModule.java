package de.htwg.seapal.waypoint.app;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import de.htwg.seapal.common.plugin.Initializable;
import de.htwg.seapal.common.plugin.Plugin;
import de.htwg.seapal.waypoint.views.tui.WaypointTUI;

public class WaypointBaseModule extends AbstractModule {

	@Override
	protected void configure() {
		Multibinder<Initializable> inits = Multibinder.newSetBinder(binder(), Initializable.class);
		inits.addBinding().to(WaypointGlobal.class);
		
		Multibinder<Plugin> plugins = Multibinder.newSetBinder(binder(), Plugin.class);
		plugins.addBinding().to(WaypointTUI.class);
	}

}
