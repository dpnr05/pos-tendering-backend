package com.lowes.pos.tendering.entity;

import com.lowes.pos.tendering.model.TenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Table(name = "tenders")
@NoArgsConstructor
@AllArgsConstructor
public class Tender {

    @Id
    private Long id;
    @Column("tender_type")
    private String tenderType;
    private BigDecimal amount;
    @Column("transaction_id")
    private String transactionId;

}
