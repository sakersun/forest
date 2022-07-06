package com.sakersun.forest.flowable.model;

import java.io.Serializable;

public class DeletionMessage implements Serializable {
    private String processKey;
    private String taskKey;
    private String event;

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

}
