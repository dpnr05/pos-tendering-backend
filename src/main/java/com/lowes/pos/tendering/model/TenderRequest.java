package com.lowes.pos.tendering.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TenderRequest {

    @NotNull
    private TenderType tenderType;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private String transactionId;
}
