package fr.eni.enchereENI.service;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent event) {
		event.getSession().setMaxInactiveInterval(5*60); // in seconds
	}

	public void sessionDestroyed(HttpSessionEvent event) {
	}
}
