package com.sakersun.forest.flowable.component;

import java.util.Arrays;
import java.util.Collection;

import org.flowable.eventregistry.api.InboundEventPayloadExtractor;
import org.flowable.eventregistry.api.runtime.EventPayloadInstance;
import org.flowable.eventregistry.impl.runtime.EventPayloadInstanceImpl;
import org.flowable.eventregistry.model.EventModel;
import org.flowable.eventregistry.model.EventPayload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class CustomPayloadExtractor implements InboundEventPayloadExtractor<JsonNode> {

    private static final String STRING_TYPE = "string";

    @Override
    public Collection<EventPayloadInstance> extractPayload(EventModel eventDefinition, JsonNode event) {

        EventPayloadInstance a1 = new EventPayloadInstanceImpl(new EventPayload("processKey", STRING_TYPE), event.get("processKey").asText());
        EventPayloadInstance a2 = new EventPayloadInstanceImpl(new EventPayload("taskKey", STRING_TYPE), event.get("taskKey").asText());
        EventPayloadInstance a3 = new EventPayloadInstanceImpl(new EventPayload("event", STRING_TYPE), event.get("event").toPrettyString());

        return Arrays.asList(a1, a2, a3);
    }
}
