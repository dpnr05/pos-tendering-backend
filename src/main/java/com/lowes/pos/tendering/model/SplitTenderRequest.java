package com.lowes.pos.tendering.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class SplitTenderRequest {

    @NotEmpty
    private List<TenderRequest> tenders;
}
