package com.example.demo.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

public record Demo(
		@Id
		Long id,

		@NotBlank(message = "The title must be defied.")
		String title,
		String content,

		@Positive
		BigDecimal price,

		@CreatedDate
		Instant createDate,

		@LastModifiedDate
		Instant lastModifiedDate,

		@Version
		int version


) {
	public static Demo of(String title, String content, BigDecimal price){
		return new Demo(null, title, content, price,null,null, 0);
	}


}
