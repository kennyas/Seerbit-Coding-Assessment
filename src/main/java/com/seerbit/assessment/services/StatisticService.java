package com.seerbit.assessment.services;

import com.seerbit.assessment.domain.Statistics;
import com.seerbit.assessment.utils.DBInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Service
public class StatisticService {
    public ResponseEntity<?> calculateStats() {
        ConcurrentMap<Long, Double> concurrentMap = DBInstance.getDBInstance();
        double min = 0, max = 0, sum = 0;
        long count = 0;

        for (Map.Entry<Long, Double> txn : concurrentMap.entrySet()) {

            double amount = txn.getValue();
            // min
            if (count == 0) {
                min = amount;
            } else if (amount < min) {
                min = amount;
            }
            // max
            if (amount > max) {
                max = amount;
            }
            // sum
            sum += amount;
            // count
            count++;
        }

        Statistics statistics = new Statistics();
        statistics.setAvg(count == 0 ? 0 : sum / count);
        statistics.setCount(count);
        statistics.setMax(roundUp(max));
        statistics.setSum(roundUp(sum));
        statistics.setMin(roundUp(min));


        return ResponseEntity.ok(statistics);
    }

    public ResponseEntity<?> delete() {
        DBInstance.getDBInstance().clear();
        return ResponseEntity.status(204).build();
    }

    private double roundUp(double input) {
        return new BigDecimal(input).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
