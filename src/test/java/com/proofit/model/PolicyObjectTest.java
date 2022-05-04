package com.proofit.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolicyObjectTest {

    @Test
    void getSumInsuredByRiskType() {
        PolicyObject policyObject = PolicyObject.builder()
                .subObjects(List.of(
                        PolicySubObject.builder()
                                .riskType(RiskType.FIRE)
                                .amount(BigDecimal.valueOf(100))
                                .build(),
                        PolicySubObject.builder()
                                .riskType(RiskType.FIRE)
                                .amount(BigDecimal.valueOf(2))
                                .build()
                )).build();

        assertEquals(0, BigDecimal.valueOf(102).compareTo(policyObject.getSumInsuredByRiskType(RiskType.FIRE)));
        assertEquals(0, BigDecimal.valueOf(0).compareTo(policyObject.getSumInsuredByRiskType(RiskType.THEFT)));
    }
}