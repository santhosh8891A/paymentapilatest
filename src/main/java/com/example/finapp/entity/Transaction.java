
package com.example.finapp.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transactions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @ManyToOne
    @JoinColumn(name="from_account_id", nullable=false)
    private Account fromAccount;
    @ManyToOne
    @JoinColumn(name="payee_id", nullable=false)
    private Payee payee;
    private BigDecimal amount;
    private LocalDate scheduledFor;
    private String status;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime confirmedAt;
}
