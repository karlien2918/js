package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Setter
@Getter
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
	private String title;
	private String contents;

}
