package org.kingpin.core.common;

import java.io.Serializable;

public class RetryDef implements Serializable {
    private static final long serialVersionUID = -506108585916941763L;
    private static final long MAX_RETRY = 65536;

    private BackoffStrategy strategy;

    private long initialDelayInMillis;

    private long maximumRetries;

    public enum BackoffStrategy {
        FIXED,
        EXPONENTIAL,
        NONE
    }

    public RetryDef(BackoffStrategy strategy, long initialDelayInMillis, long maximumRetries) {
        this.strategy = strategy;
        this.initialDelayInMillis = initialDelayInMillis;
        this.maximumRetries = maximumRetries;
    }

    public RetryDef(BackoffStrategy strategy, long initialDelayInMillis) {
        this(strategy, initialDelayInMillis, MAX_RETRY);
    }

    public RetryDef() {
    }

    public BackoffStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(BackoffStrategy strategy) {
        this.strategy = strategy;
    }

    public long getInitialDelayInMillis() {
        return initialDelayInMillis;
    }

    public void setInitialDelayInMillis(long initialDelayInMillis) {
        this.initialDelayInMillis = initialDelayInMillis;
    }

    public long getMaximumRetries() {
        return maximumRetries;
    }

    public void setMaximumRetries(long maximumRetries) {
        this.maximumRetries = maximumRetries;
    }

    @Override
    public String toString() {
        return "RetryDef{" +
                "strategy=" + strategy +
                ", initialDelayInMillis=" + initialDelayInMillis +
                ", maximumRetries=" + maximumRetries +
                '}';
    }

    public static RetryDef fixedBackoff(long delay) {
        return new RetryDef(BackoffStrategy.FIXED, delay);
    }

    public static RetryDef fixedBackoff(long delay, long maxRetry) {
        return new RetryDef(BackoffStrategy.FIXED, delay, maxRetry);
    }

    public static RetryDef exponentialBackoff(long delay) {
        return new RetryDef(BackoffStrategy.EXPONENTIAL, delay);
    }

    public static RetryDef exponentialBackoff(long delay, long maxRetry) {
        return new RetryDef(BackoffStrategy.EXPONENTIAL, delay, maxRetry);
    }
}
