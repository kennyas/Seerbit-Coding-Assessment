package com.seerbit.assessment.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class TransactionRequest {
    @NotNull(message = "timestamp is mandatory")
    private Instant timestamp;
    @NotNull(message = "transaction amount is mandatory")
    private Double amount;
}
