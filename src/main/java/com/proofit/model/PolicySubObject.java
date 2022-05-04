package com.proofit.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class PolicySubObject {
    private String name;
    private RiskType riskType;
    private BigDecimal amount;
}
