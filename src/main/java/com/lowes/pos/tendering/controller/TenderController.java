package com.lowes.pos.tendering.controller;

import com.lowes.pos.tendering.model.TenderRequest;
import com.lowes.pos.tendering.service.TenderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/pos/tenders")
@RequiredArgsConstructor
public class TenderController {

    private final TenderService tenderService;

    @PostMapping
    public Mono<?> createTender(@Valid @RequestBody TenderRequest request) {
        request.setTransactionId(UUID.randomUUID().toString());
        return tenderService.createTender(request);
    }


}
