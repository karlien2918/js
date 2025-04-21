package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DemoService {

	private final Environment environment;
	private final DemoRepository demoRepository;


	public String getPort() {
		return environment.getProperty("server.port");
	}

	public List<Demo> findByAll() {
		return demoRepository.findByAll();
	}

	public Demo editTitle(String title) {
		return demoRepository.findByTitle(title)
				.map(existingDemo -> {
					var editDemo = new Demo(
							existingDemo.id(),
							title,
							title + "contents v2",
							new BigDecimal(1),
							existingDemo.createDate(),
							existingDemo.lastModifiedDate(),
							existingDemo.version()
					);
					return demoRepository.save(editDemo);
				})
				.orElseGet(() -> addDemo(title));
	}

	private Demo addDemo(String title) {
		return demoRepository.add(title);
	}
}
