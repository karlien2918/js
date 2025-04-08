package com.example.demo.domain;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DemoController {

	private final DemoService demoService;
	private final DemoProperties demoProperties;

	@GetMapping
	public ResponseEntity<String> index(){
		String port = demoService.getPort();
		String title = demoProperties.getTitle();
		return ResponseEntity.ok(title + ". Current Port : " + port);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Demo>> getDemo(){
		List<Demo> byAll = demoService.findByAll();
		return new ResponseEntity<>(byAll, HttpStatus.OK);
	}


	@GetMapping(value = "/properties")
	public ResponseEntity<String> get(){
		String contents = demoProperties.getContents();
		return ResponseEntity.ok(contents);
	}
}
