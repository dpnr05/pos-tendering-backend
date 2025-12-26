package com.lowes.pos.tendering.entity;

import com.lowes.pos.tendering.model.TenderType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tender")
@NoArgsConstructor
@AllArgsConstructor
public class Tender {

    @Id
    private Long id;

    private TenderType tenderType;
    private BigDecimal amount;
    private String transactionId;
    private LocalDateTime createdAt;
}
