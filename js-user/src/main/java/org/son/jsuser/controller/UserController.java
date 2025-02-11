package org.son.jsuser.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

	Environment env;

	public UserController(Environment env) {
		this.env = env;
	}

	@GetMapping("/index")
	public String index(HttpServletRequest request) {
		return String.format("Server name ={}, port ={}", env.toString(), request.getServerPort());

	}
}
