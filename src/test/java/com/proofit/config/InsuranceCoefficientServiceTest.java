package com.proofit.config;

import com.proofit.model.RiskType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InsuranceCoefficientServiceTest {

    @Autowired
    private InsuranceCoefficientService insuranceCoefficientService;

    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(RiskType.FIRE, BigDecimal.valueOf(10), BigDecimal.valueOf(0.014)),
                Arguments.of(RiskType.FIRE, BigDecimal.valueOf(100), BigDecimal.valueOf(0.014)),
                Arguments.of(RiskType.FIRE, BigDecimal.valueOf(102), BigDecimal.valueOf(0.024)),
                Arguments.of(RiskType.THEFT, BigDecimal.valueOf(10), BigDecimal.valueOf(0.11)),
                Arguments.of(RiskType.THEFT, BigDecimal.valueOf(15), BigDecimal.valueOf(0.05)),
                Arguments.of(RiskType.THEFT, BigDecimal.valueOf(20), BigDecimal.valueOf(0.05))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void getCoefficientTest(RiskType riskType, BigDecimal amount, BigDecimal expectedCoefficient) {
        assertEquals(expectedCoefficient, insuranceCoefficientService.getCoefficient(riskType, amount));

    }
}