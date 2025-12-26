package com.lowes.pos.tendering.entity;

import com.lowes.pos.tendering.model.TenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
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
