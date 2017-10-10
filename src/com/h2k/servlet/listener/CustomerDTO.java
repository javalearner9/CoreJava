package com.h2k.servlet.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class CustomerDTO implements HttpSessionBindingListener {
	
	private String firstName;
	private String lastName;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionBindingListenerImpl :: valueBound " );
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionBindingListenerImpl :: valueUnbound "  );
	}

}
