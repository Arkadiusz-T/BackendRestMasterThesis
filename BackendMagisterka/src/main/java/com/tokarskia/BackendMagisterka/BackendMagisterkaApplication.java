package com.tokarskia.BackendMagisterka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BackendMagisterkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendMagisterkaApplication.class, args);
	}

}
