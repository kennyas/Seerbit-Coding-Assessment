package com.seerbit.assessment.services;

import com.seerbit.assessment.domain.TransactionRequest;
import com.seerbit.assessment.exception.TransactionTimeException;
import com.seerbit.assessment.utils.DBInstance;
import com.seerbit.assessment.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionService {


    public ResponseEntity<?> createTransaction(TransactionRequest transactionRequest) throws TransactionTimeException, IllegalArgumentException {
        Utils.validateTimeDiff(transactionRequest);
        //When write is successful, return 201
        DBInstance.getDBInstance().put(transactionRequest.getTimestamp(), transactionRequest.getAmount());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
