package com.lowes.pos.tendering.controller;
import com.lowes.pos.tendering.model.SplitTenderRequest;
import com.lowes.pos.tendering.model.TenderRequest;
import com.lowes.pos.tendering.model.TenderResponse;
import com.lowes.pos.tendering.service.TenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
