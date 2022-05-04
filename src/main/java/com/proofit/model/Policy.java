package com.proofit.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
public class Policy {
    private String name;
    private PolicyStatus status;
    private List<PolicyObject> policyObjects;

    public BigDecimal getSumInsuredByRiskType(RiskType riskType) {
        return this.policyObjects.stream()
                .map(policyObject -> policyObject.getSumInsuredByRiskType(riskType))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
