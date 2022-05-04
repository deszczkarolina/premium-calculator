package com.proofit.service;

import com.proofit.model.Policy;
import com.proofit.model.PolicyObject;
import com.proofit.model.PolicySubObject;
import com.proofit.model.RiskType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PremiumCalculatorTest {

    @Autowired
    private PremiumCalculator calculator;

    @Test
    void calculatePolicyPremiumWithDefaultCoefficients() {
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
                                                .amount(BigDecimal.valueOf(8))
                                                .build()
                                )).build()
                )).build();

        assertEquals(BigDecimal.valueOf(2.28), calculator.calculate(policy));
    }

    @Test
    void calculatePolicyPremiumWithAdjustedCoefficients() {
        Policy policy = Policy.builder()
                .policyObjects(List.of(
                        PolicyObject.builder()
                                .subObjects(List.of(
                                        PolicySubObject.builder()
                                                .riskType(RiskType.FIRE)
                                                .amount(BigDecimal.valueOf(500))
                                                .build(),
                                        PolicySubObject.builder()
                                                .riskType(RiskType.THEFT)
                                                .amount(BigDecimal.valueOf(102.51))
                                                .build()
                                )).build()
                )).build();

        assertEquals(BigDecimal.valueOf(17.13), calculator.calculate(policy));
    }
}