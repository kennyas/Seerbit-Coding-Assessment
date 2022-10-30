package com.seerbit.assessment.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DBInstance {
    private static ConcurrentMap<Long, Double> concurrentMap = null;

    public static ConcurrentMap getDBInstance() {
        if (concurrentMap == null) {
            concurrentMap = new ConcurrentHashMap<Long, Double>();
        }
        return concurrentMap;
    }
}
