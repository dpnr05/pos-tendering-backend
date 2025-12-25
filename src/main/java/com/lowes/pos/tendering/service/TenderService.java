package com.lowes.pos.tendering.service;

import com.lowes.pos.tendering.entity.Tender;
import com.lowes.pos.tendering.model.TenderRequest;
import com.lowes.pos.tendering.repository.TenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TenderService {

    private final TenderRepository tenderRepository;

    public Mono<Tender> createTender(TenderRequest request) {
        Tender tender = new Tender();
        tender.setTenderType(request.getTenderType().name());
        tender.setAmount(request.getAmount());
        tender.setTransactionId(request.getTransactionId());
        tender.setCreatedAt(LocalDateTime.now());

        return tenderRepository.save(tender);
    }
}
