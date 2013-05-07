package de.htwg.seapal.waypoint.app;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.seapal.common.plugin.HookHandler;
import de.htwg.seapal.common.plugin.HookRegistry;
import de.htwg.seapal.common.plugin.Initializable;
import de.htwg.seapal.mark.app.MarkImplModule;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.api.templates.Html;
import scala.collection.mutable.StringBuilder;

public class WaypointGlobal extends GlobalSettings implements Initializable {
	private static Injector INJECTOR;

	public static Injector createInjector() {
		return Guice.createInjector(new WaypointImplModule(),
				new MarkImplModule());
	}

	@Override
	public <A> A getControllerInstance(Class<A> controllerClass)
			throws Exception {
		if (INJECTOR == null) {
			INJECTOR = createInjector();
		}

		return INJECTOR.getInstance(controllerClass);
	}


	@Override
	public void onStop(Application app) {
		Logger.info("Waypoint app shutdown...");
	}

	@Override
	public void initHooks(HookRegistry registry) {
		registry.registerHook("menu.show", new HookHandler<Html, Object>(Html.class, Object.class){

			@Override
			public Html execute(Object nothing) {
				StringBuilder builder = new StringBuilder();
				builder.append("<a href=\">")
					.append(de.htwg.seapal.waypoint.controllers.routes.PlayWaypointController.test())
					.append("\">")
					.append("Trip")
					.append("</a>");
				
				return new Html(builder);
			}
		});
	}
}
