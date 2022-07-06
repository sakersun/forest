package com.sakersun.forest.flowable.component;

import org.flowable.eventregistry.api.InboundEventDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sakersun.forest.flowable.model.DeletionMessage;

@Component
public class CustomDeserializer implements InboundEventDeserializer<DeletionMessage> {
    @Autowired
    private Gson gson;

    @Override
    public DeletionMessage deserialize(String rawEvent) {
        JsonObject json = gson.fromJson(rawEvent, JsonObject.class);
        String processKey = json.get("processKey").getAsString();
        String taskKey = json.get("taskKey").getAsString();
        String event = json.get("event").getAsString();

        DeletionMessage message = new DeletionMessage();
        message.setProcessKey(processKey);
        message.setTaskKey(taskKey);
        message.setEvent(event);
        return message;
    }
}
