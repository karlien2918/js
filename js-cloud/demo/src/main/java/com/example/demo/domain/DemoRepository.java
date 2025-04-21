package com.example.demo.domain;


import java.util.List;
import java.util.Optional;

public interface DemoRepository {
	Optional<Demo> findById(String id);
	Demo save(Demo demo);
	List<Demo> findByAll();
	Optional<Demo> findByTitle(String title);

	Demo add(String title);
}
