package org.kingpin.server.common;

public enum TaskStatus {
    //Task completed successfully
    Completed,

    // Task failed to complete
    Failed,

    // Task failed to complete but can be retried
    Retryable_Failed
}
