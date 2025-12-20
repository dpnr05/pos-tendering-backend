package com.lowes.pos.tendering.service

import com.lowes.pos.tendering.model.TenderRequest
import com.lowes.pos.tendering.model.TenderType
import reactor.test.StepVerifier
import spock.lang.Specification

class TenderServiceSpec extends Specification {

    def tenderService = new TenderService()

    def "should approve a valid tender"() {

        given: "a valid tender request"
        def request = new TenderRequest(
                tenderType: TenderType.CREDIT_CARD,
                amount: 100,
                transactionId: "TXN-SP-1"
        )

        when: "tender is processed"
        def result = tenderService.processTender(request)

        then: "response should be approved"
        StepVerifier.create(result)
                .expectNextMatches { it.status == "APPROVED" }
                .verifyComplete()
    }
}
