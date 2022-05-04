package com.proofit.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
public class PolicyObject {
    private String name;
    private List<PolicySubObject> subObjects;

    protected BigDecimal getSumInsuredByRiskType(RiskType riskType) {
        return this.subObjects.stream()
                .filter(policySubObject -> riskType.equals(policySubObject.getRiskType()))
                .map(PolicySubObject::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
