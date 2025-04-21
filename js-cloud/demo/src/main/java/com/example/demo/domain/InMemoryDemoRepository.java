package com.example.demo.domain;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryDemoRepository implements DemoRepository {
	private final Map<String, Demo> demos = new ConcurrentHashMap<>();

	@Override
	public Optional<Demo> findById(String id) {
		return Optional.ofNullable(demos.get(id));
	}

	@Override
	public Demo save(Demo demo) {
		return demos.put(demo.title(), demo);
	}

	@Override
	public List<Demo> findByAll() {
		return demos.values().stream().toList();
	}

	@Override
	public Optional<Demo> findByTitle(String title) {
		return Optional.ofNullable(demos.get(title));
	}

	@Override
	public Demo add(String title) {
		return Demo.of(title, title+ " contents", new BigDecimal(1));
	}
}
