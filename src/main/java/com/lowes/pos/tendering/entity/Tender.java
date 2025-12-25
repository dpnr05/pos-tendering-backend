package com.lowes.pos.tendering.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table("tender")
public class Tender {

    @Id
    private Long id;

    private String tenderType;
    private BigDecimal amount;
    private String transactionId;
    private LocalDateTime createdAt;
}
