package com.seerbit.assessment.exception;

import org.springframework.lang.Nullable;

public class TransactionTimeException extends RuntimeException {
    public TransactionTimeException() {

    }
    public TransactionTimeException(String msg) {
        super(msg);
    }

    public TransactionTimeException(String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }
}
