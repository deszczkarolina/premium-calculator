package com.proofit.service;

import com.proofit.config.InsuranceCoefficientService;
import com.proofit.model.Policy;
import com.proofit.model.RiskType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class PremiumCalculator {
    private final InsuranceCoefficientService insuranceCoefficientService;

    public BigDecimal calculate(Policy policy) {
        return Arrays.stream(RiskType.values())
                .map(riskType -> {
                    BigDecimal sumInsuredByRiskType = policy.getSumInsuredByRiskType(riskType);
                    BigDecimal coefficient = insuranceCoefficientService.getCoefficient(riskType, sumInsuredByRiskType);
                    return sumInsuredByRiskType.multiply(coefficient);
                }).reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.UP);
    }
}
