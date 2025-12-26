package com.lowes.pos.tendering.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tender")
public class Tender {

    @Id
    private Long id;

    private String tenderType;
    private BigDecimal amount;
    private String transactionId;
    private LocalDateTime createdAt;
}
