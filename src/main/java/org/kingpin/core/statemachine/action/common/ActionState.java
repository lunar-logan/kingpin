package org.kingpin.core.statemachine.action.common;

public enum ActionState {
    INITIALIZED,
    TRIGGERED,
    COMPLETED,
    FAILED,
    RETRYABLE_FAILED
}
