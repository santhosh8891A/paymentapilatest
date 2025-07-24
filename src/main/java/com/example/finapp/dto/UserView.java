package com.example.finapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class UserView {
	private Long userId;
	private String username;
	private OffsetDateTime createdAt;
}
