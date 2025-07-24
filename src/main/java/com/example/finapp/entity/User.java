
package com.example.finapp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String passwordHash;
	@Column(nullable = false)
	private String txPasswordHash;
	private OffsetDateTime createdAt = OffsetDateTime.now();

	// (only showing additions)
	@PrePersist
	public void prePersist() {
		if (createdAt == null)
			createdAt = OffsetDateTime.now();
	}

}
