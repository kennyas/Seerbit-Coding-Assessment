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

    // Getter
    public Instant getTimestamp() {
        return timestamp;
    }

    // Setter
    public void setTimestamp(Instant newTimestamp) {
        this.timestamp = newTimestamp;
    }

    // Getter
    public double getAmount() {
        return amount;
    }

    // Setter
    public void setAmount(double newAmount) {
        this.amount = newAmount;
    }
}
