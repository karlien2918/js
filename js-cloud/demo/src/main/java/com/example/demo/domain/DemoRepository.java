package com.example.demo.domain;


import java.util.List;
import java.util.Optional;

public interface DemoRepository {
	Optional<Demo> findById(String id);
	void save(Demo demo);
	List<Demo> findByAll();
}
