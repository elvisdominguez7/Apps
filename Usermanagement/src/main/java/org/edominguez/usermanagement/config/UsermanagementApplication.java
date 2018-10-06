package org.edominguez.usermanagement.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootConfiguration
public class UsermanagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}
}
