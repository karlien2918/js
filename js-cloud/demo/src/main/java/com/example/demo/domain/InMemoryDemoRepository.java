package com.example.demo.domain;


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
	public void save(Demo demo) {
		demos.put(demo.title(), demo);
	}

	@Override
	public List<Demo> findByAll() {
		return demos.values().stream().toList();
	}
}
