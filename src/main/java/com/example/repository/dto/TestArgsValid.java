package com.example.repository.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class TestArgsValid {
	@NotNull(message = "text not null")
	private String text;
	@Email(message = "invalid email address")
	private String email;
	@Min(0)
	@Max(100)
	@NotNull(message = "number is required")
	private Integer number;
}
