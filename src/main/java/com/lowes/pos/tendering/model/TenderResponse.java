package com.lowes.pos.tendering.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TenderResponse {
    private Long id;
    private TenderType tenderType;
    private BigDecimal amount;
}
