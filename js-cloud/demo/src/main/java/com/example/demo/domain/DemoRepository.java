package com.example.demo.domain;


import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DemoRepository extends CrudRepository<Demo, Long> {
	Optional<Demo> findByTitle(String title);
	boolean existsByTitle(String title);

	@Modifying
	@Transactional
	@Query("delete from demo d where title = :title")
	void deleteByTitle(@Param("title") String title);
}
