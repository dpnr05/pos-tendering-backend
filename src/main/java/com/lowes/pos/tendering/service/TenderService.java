package com.lowes.pos.tendering.service;
import com.lowes.pos.tendering.entity.Tender;
import com.lowes.pos.tendering.model.SplitTenderRequest;
import com.lowes.pos.tendering.model.TenderRequest;
import com.lowes.pos.tendering.model.TenderResponse;
import com.lowes.pos.tendering.repository.TenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TenderService {

    private final TenderRepository repository;

    public Mono<TenderResponse> create(TenderRequest request) {
        Tender tender = new Tender();   // ✅ default constructor
        tender.setTenderType(request.getTenderType().name());
        tender.setAmount(request.getAmount());
        tender.setTransactionId(request.getTransactionId());
        return repository.save(tender)
                .map(t -> new TenderResponse(
                        t.getId(),
                        t.getTenderType(),
                        t.getAmount(),
                        t.getTransactionId()
                ));
    }

    public Flux<TenderResponse> createSplit(SplitTenderRequest request) {
        return Flux.fromIterable(request.getTenders())
                .flatMap(this::create);
    }
}
