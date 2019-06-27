package org.kingpin.server.task;

public class TaskImage {
    public enum Status {
        Scheduled,
        Running,
        Completed,
        Failed,
        Stopped,
        Paused
    }

    private final String name;

    /**
     * Name of the queue of which its worker is listening to
     */
    private final String queue;

    private final RetryConfig retry;


    public TaskImage(String name, String queue, RetryConfig retry) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name of the task cannot be null or empty");
        }

        if (queue == null || queue.isBlank()) {
            throw new IllegalArgumentException("Name of the worker queue cannot be null or empty");
        }

        if (retry == null) {
            throw new IllegalArgumentException("Retry configuration must not be null");
        }
        this.name = name;
        this.queue = queue;
        this.retry = retry;
    }

    public String getName() {
        return name;
    }

    public String getQueue() {
        return queue;
    }

    public RetryConfig getRetry() {
        return retry;
    }

    @Override
    public String toString() {
        return "TaskImage{" +
                "name='" + name + '\'' +
                ", queue='" + queue + '\'' +
                ", retry=" + retry +
                '}';
    }
}
