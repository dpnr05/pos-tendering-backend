package com.lowes.pos.tendering.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenderRequest {

    @NotNull
    private TenderType tenderType;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private String transactionId;
}
