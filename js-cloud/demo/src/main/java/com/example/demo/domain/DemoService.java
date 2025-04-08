package com.example.demo.domain;

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
}
