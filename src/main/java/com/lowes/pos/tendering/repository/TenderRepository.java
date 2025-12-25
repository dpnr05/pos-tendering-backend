package com.lowes.pos.tendering.repository;

import com.lowes.pos.tendering.entity.Tender;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TenderRepository extends ReactiveCrudRepository<Tender, Long> {

    Flux<Tender> findByTransactionId(String transactionId);
}
