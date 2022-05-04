# premium-calculator

PremiumCalculator returning the price that needs to be paid for specific insurance policy.

Note: as indicated in test cases the scale of returned value should be equal to 2. In presented solution the approximation is performed as the last step on the sum including all risk factors. Up rounding strategy has been chosen.

#### Adding new risk types
In order to extend the calculator with new risk types following changes need to be introduced:
1. Configuration of new risk type's coefficients in application.properties + adding new corresponding fields in ConfigProperties.java
2. Adding new case branch in switch statement in InsuranceCoefficientService for newly introduced risk type.
