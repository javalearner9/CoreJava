package com.h2k.servlet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttibuteListernerImpl implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("Added :: " + event.getName() + " Value :: " + event.getValue());  

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Removed :: " + event.getName() + " Value :: " + event.getValue());

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Replaced :: " + event.getName() + " Old Value :: " + event.getValue());

	}

}
