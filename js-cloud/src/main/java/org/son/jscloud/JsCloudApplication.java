package org.son.jscloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JsCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsCloudApplication.class, args);
	}

}
