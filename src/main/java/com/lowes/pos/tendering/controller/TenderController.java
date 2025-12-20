package com.lowes.pos.tendering.controller;

import com.lowes.pos.tendering.model.SplitTenderRequest;
import com.lowes.pos.tendering.model.TenderRequest;
import com.lowes.pos.tendering.model.TenderResponse;
import com.lowes.pos.tendering.service.TenderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/pos/tenders")
@RequiredArgsConstructor
public class TenderController {

    private final TenderService tenderService;

    @PostMapping
    public Mono<TenderResponse> processTender(@Valid @RequestBody TenderRequest request) {
        return tenderService.processTender(request);
    }
    @PostMapping("/split")
    public Flux<TenderResponse> processSplitTender(
            @Valid @RequestBody SplitTenderRequest request) {
        return tenderService.processSplitTender(request);
    }

}
