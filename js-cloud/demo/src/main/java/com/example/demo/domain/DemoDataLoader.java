package com.example.demo.domain;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("local")
@Slf4j
public class DemoDataLoader {
	private final DemoRepository demoRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void loadTestData(){
		var demo = Demo.of("id1", "contents1", new BigDecimal(1));
		var demo2 = Demo.of("id2", "contents2", new BigDecimal(2));
		demoRepository.save(demo);
		demoRepository.save(demo2);
		log.debug("Demo data loaded");
	}
}
