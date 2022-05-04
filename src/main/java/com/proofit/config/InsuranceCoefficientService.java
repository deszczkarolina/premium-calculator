package com.proofit.config;

import com.proofit.model.RiskType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class InsuranceCoefficientService {
    private final ConfigProperties properties;

    public BigDecimal getCoefficient(RiskType riskType, BigDecimal amount) {
        switch (riskType) {
            case FIRE:
                return amount.compareTo(properties.getFireSumThreshold()) > 0
                        ? properties.getAdjustedFireCoefficient()
                        : properties.getDefaultFireCoefficient();
            case THEFT:
                return amount.compareTo(properties.getTheftSumThreshold()) >= 0
                        ? properties.getAdjustedTheftCoefficient()
                        : properties.getDefaultTheftCoefficient();
            default:
                throw new IllegalStateException("Unexpected value: " + riskType);
        }
    }
}
