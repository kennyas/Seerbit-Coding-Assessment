package com.seerbit.assessment.domain;

import lombok.Data;

@Data
public class Statistics {
    private double min;
    private double max;
    private double avg;
    private double sum;
    private long count;
}
