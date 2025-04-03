package org.son.jscloud;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Slf4j
public class JsCloudApplication {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");

		String key1 = map.compute("key1", (k, v) -> v == null ? "" : v);

		log.info(key1);



	}

}
