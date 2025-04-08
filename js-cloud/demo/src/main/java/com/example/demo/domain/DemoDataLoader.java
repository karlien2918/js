package com.example.demo.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("testdata")
@Slf4j
public class DemoDataLoader {
	private final DemoRepository demoRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void loadTestData(){
		var demo = new Demo("id1", "contents1");
		var demo2 = new Demo("id2", "contents2");
		demoRepository.save(demo);
		demoRepository.save(demo2);
		log.debug("Demo data loaded");
	}
}
