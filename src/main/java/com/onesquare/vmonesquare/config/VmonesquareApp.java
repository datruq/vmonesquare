package com.onesquare.vmonesquare.config;

import com.onesquare.vmonesquare.web.app.VmonesquareAppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		VmonesquareAppController.class,
		DomainBeans.class
})
public class VmonesquareApp {

	public static void main(String[] args) {
		SpringApplication.run(VmonesquareApp.class, args);
	}

}
