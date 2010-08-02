package com.leanvienna.studentlife.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.leanvienna.studentlife.client.composites.Tabs;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Studentlife_gwt implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Tabs tabs = new Tabs();
		RootPanel.get("content").add(tabs);
	}
}
