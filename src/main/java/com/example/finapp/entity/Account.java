
package com.example.finapp.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "accounts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private String accountType;
    @Column(unique=true)
    private String accountNumber;
    private String sortCode;
    private BigDecimal balance = BigDecimal.ZERO;
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
