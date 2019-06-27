package org.kingpin.core.statemachine.action.common;

import org.kingpin.core.common.RetryDef;

import java.io.Serializable;
import java.util.Set;

public class ActionRetry implements Serializable {
    private static final long serialVersionUID = 810252842896244567L;

    public static final ActionRetry NO_RETRY = new ActionRetry();

    private Set<ActionResult> results;

    private RetryDef retry;

    public Set<ActionResult> getResults() {
        return results;
    }

    public void setResults(Set<ActionResult> results) {
        this.results = results;
    }

    public RetryDef getRetry() {
        return retry;
    }

    public void setRetry(RetryDef retry) {
        this.retry = retry;
    }

    @Override
    public String toString() {
        return "ActionRetry{" +
                "results=" + results +
                ", retry=" + retry +
                '}';
    }
}
