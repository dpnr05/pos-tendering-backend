package com.lowes.pos.tendering.service;

import com.lowes.pos.tendering.model.SplitTenderRequest;
import com.lowes.pos.tendering.model.TenderRequest;
import com.lowes.pos.tendering.model.TenderResponse;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
public class TenderService {

    public Mono<TenderResponse> processTender(TenderRequest request) {
        log.info("Processing tender request | transactionId={} | amount={} | tenderType={}",
                request.getTransactionId(),
                request.getAmount(),
                request.getTenderType());

        return Mono.just(request)
                .flatMap(this::authorizePayment)
                .map(req -> {
                    log.info("Tender approved | transactionId={}", req.getTransactionId());
                    return new TenderResponse(req.getTransactionId(), "APPROVED");
                })
                .onErrorResume(ex -> {
                    log.error("Tender declined | transactionId={}", request.getTransactionId(), ex);
                    return Mono.just(new TenderResponse(request.getTransactionId(), "DECLINED"));
                });
    }

    private Mono<TenderRequest> authorizePayment(TenderRequest request) {
        log.debug("Authorizing payment | transactionId={}", request.getTransactionId());
        return Mono.just(request);
    }

    public Flux<TenderResponse> processSplitTender(SplitTenderRequest request) {
        Optional<TenderRequest> primary =
                request.getTenders().stream().findFirst();

        return Flux.fromIterable(request.getTenders())
                .flatMap(this::authorizePayment)
                .map(t -> new TenderResponse(t.getTransactionId(), "APPROVED"));
    }

    // ✅ CLEAN SHUTDOWN HOOK
    @PreDestroy
    public void shutdown() {
        log.info("Gracefully shutting down Tendering Service");
    }
}
