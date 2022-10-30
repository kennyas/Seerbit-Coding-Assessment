package com.seerbit.assessment.utils;

import com.seerbit.assessment.domain.TransactionRequest;
import com.seerbit.assessment.exception.TransactionTimeException;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
public class Utils {

    public static final Integer seconds = 60000;//Time in 30secs

    public static void validateTimeDiff(TransactionRequest txn) throws
            TransactionTimeException, IllegalArgumentException {
        Instant receiveTime = Instant.now();
        long expirationTime = receiveTime
                .minusMillis(seconds)
                //.minusMillis(10L)
                .toEpochMilli();
        long txnTime = txn.getTimestamp().toEpochMilli();
        log.debug("Input txn to validate: {}", txn);
        log.info("expirationTime : {}", expirationTime);
        log.info("txnTime: {}", txnTime);

        if (txnTime < expirationTime) {
            log.error("Transaction is out-dated");
            throw new TransactionTimeException("Transaction is out-dated");
        }
        log.debug("Validation passed!");
    }
}
