package com.java.application.actuator;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthMartix implements HealthIndicator {

	@Override
	public Health health() {
		Health health = null;
		health = checkInternet() == true ? Health.up().withDetail("Sucess", "Active Internet Connection").build()
				: Health.down().withDetail("error code", "Inactive Internet Connection").build();
		return health;
	}

	private boolean checkInternet() {
		boolean flag = false;
		try {
			URL url = new URL("https://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

}
