package org.kingpin.server.task;

public class RetryConfig {
    private final int maxRetries;
    private final long initialDelay;
    private final Backoff backoff;

    public RetryConfig(int maxRetries, long initialDelay, Backoff backoff) {
        if (maxRetries < 0) {
            throw new IllegalArgumentException("Maximum retry count must be non negative");
        }
        if (initialDelay < 0) {
            throw new IllegalArgumentException("Initial delay must be positive integer");
        }
        if (backoff == null) {
            backoff = Backoff.Fixed;
        }
        this.maxRetries = maxRetries;
        this.initialDelay = initialDelay;
        this.backoff = backoff;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public long getInitialDelay() {
        return initialDelay;
    }

    public Backoff getBackoff() {
        return backoff;
    }

    @Override
    public String toString() {
        return "RetryConfig{" +
                "maxRetries=" + maxRetries +
                ", initialDelay=" + initialDelay +
                ", backoff=" + backoff +
                '}';
    }

    public enum Backoff {
        Fixed,
        Exponential
    }
}
