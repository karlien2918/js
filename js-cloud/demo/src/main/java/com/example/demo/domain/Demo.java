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
		String contents,

		@Positive
		BigDecimal price,

		String publisher,

		@CreatedDate
		Instant createDate,

		@LastModifiedDate
		Instant lastModifiedDate,

		@Version
		int version


) {
	public static Demo of(String title, String content, BigDecimal price, String publisher){
		return new Demo(null, title, content, price,publisher, null,null, 0);
	}
}
