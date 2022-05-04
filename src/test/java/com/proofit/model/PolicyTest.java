package com.proofit.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolicyTest {

    @Test
    void getSumInsuredByRiskType() {
        Policy policy = Policy.builder()
                .policyObjects(List.of(
                        PolicyObject.builder()
                                .subObjects(List.of(
                                        PolicySubObject.builder()
                                                .riskType(RiskType.FIRE)
                                                .amount(BigDecimal.valueOf(100))
                                                .build(),
                                        PolicySubObject.builder()
                                                .riskType(RiskType.THEFT)
                                                .amount(BigDecimal.valueOf(80))
                                                .build()
                                )).build(),
                        PolicyObject.builder()
                                .subObjects(List.of(
                                        PolicySubObject.builder()
                                                .riskType(RiskType.THEFT)
                                                .amount(BigDecimal.valueOf(100))
                                                .build(),
                                        PolicySubObject.builder()
                                                .riskType(RiskType.THEFT)
                                                .amount(BigDecimal.valueOf(8))
                                                .build()
                                )).build()
                )).build();

        assertEquals(0, BigDecimal.valueOf(100).compareTo(policy.getSumInsuredByRiskType(RiskType.FIRE)));
        assertEquals(0, BigDecimal.valueOf(188).compareTo(policy.getSumInsuredByRiskType(RiskType.THEFT)));
    }
}