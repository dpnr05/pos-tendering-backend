package com.lowes.pos.tendering.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TenderResponse {
    private String transactionId;
    private String status;
}
