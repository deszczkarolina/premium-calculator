package com.proofit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@ConfigurationProperties("app")
@Getter
@Setter
public class ConfigProperties {
    private BigDecimal defaultFireCoefficient;
    private BigDecimal adjustedFireCoefficient;
    private BigDecimal defaultTheftCoefficient;
    private BigDecimal adjustedTheftCoefficient;
    private BigDecimal fireSumThreshold;
    private BigDecimal theftSumThreshold;
}
