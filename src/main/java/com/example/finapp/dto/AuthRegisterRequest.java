package com.example.finapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRegisterRequest {
	@NotBlank
	private String username;
	@NotBlank
	private String password; // plain; will be hashed
	@NotBlank
	private String txPassword; // plain; will be hashed
}
