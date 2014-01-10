package com.badlogic.assault.html;

import com.badlogic.assault.core.Assault;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class AssaultHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Assault();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
