package com.seerbit.assessment.domain;

import lombok.Data;

@Data
public class Statistics {
    private double min;
    private double max;
    private double avg;
    private double sum;
    private long count;


    // Getter
    public double getMin() {
        return min;
    }

    // Setter
    public void setMin(double newMin) {
        this.min = newMin;
    }
    // Getter
    public double getMax() {
        return max;
    }

    // Setter
    public void setMax(double newMax) {
        this.max = newMax;
    }

    // Getter
    public double getAvg() {
        return avg;
    }

    // Getter
    public double getSum() {
        return sum;
    }

    // Setter
    public void setSum(double newSum) {
        this.sum = newSum;
    }

    // Setter
    public void setAvg(double newAvg) {
        this.avg = newAvg;
    }

    // Getter
    public long getCount() {
        return count;
    }

    // Setter
    public void setCount(long newCount) {
        this.count = newCount;
    }
}
