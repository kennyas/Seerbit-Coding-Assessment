package com.seerbit.assessment.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class TransactionRequest {
    @NotNull(message = "timestamp is required")
    private Instant timestamp;
    @NotNull(message = "amount is required")
    private Double amount;
}
