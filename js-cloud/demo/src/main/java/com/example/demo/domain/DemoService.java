package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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
		final Iterable<Demo> demos = demoRepository.findAll();
		return StreamSupport.stream(demos.spliterator(), false).toList();
	}

	public Demo editTitle(String title) {
		return demoRepository.findByTitle(title)
				.map(existingDemo -> {
					var editDemo = Demo.of(
							title,
							title + "contents v2",
							new BigDecimal(1),
							existingDemo.publisher()
					);
					return demoRepository.save(editDemo);
				})
				.orElseGet(() -> addDemo(title));
	}

	void deleteByTitle(String title){
		demoRepository.deleteByTitle(title);
	}

	private Demo addDemo(String title) {
		return demoRepository.save(Demo.of(title, title, new BigDecimal(5), null));
	}
}
