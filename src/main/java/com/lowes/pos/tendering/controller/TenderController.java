package com.lowes.pos.tendering.controller;
import com.lowes.pos.tendering.model.SplitTenderRequest;
import com.lowes.pos.tendering.model.TenderRequest;
import com.lowes.pos.tendering.model.TenderResponse;
import com.lowes.pos.tendering.service.TenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/tenders")
@RequiredArgsConstructor
public class TenderController {

    private final TenderService service;

    @PostMapping
    public Mono<TenderResponse> create(
            @RequestBody Mono<TenderRequest> requestMono) {
        return requestMono.flatMap(service::create);
    }

    @PostMapping("/split")
    public Flux<TenderResponse> createSplit(
            @RequestBody Mono<SplitTenderRequest> requestMono) {
        return requestMono.flatMapMany(service::createSplit);
    }
}
