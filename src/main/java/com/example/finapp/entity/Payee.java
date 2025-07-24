
package com.example.finapp.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "payees")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Payee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payeeId;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private String name;
    private String accountNumber;
    private String sortCode;
    private Boolean isInternal = false;
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
