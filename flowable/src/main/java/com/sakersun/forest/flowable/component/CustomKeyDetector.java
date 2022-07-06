package com.sakersun.forest.flowable.component;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.flowable.eventregistry.api.InboundEventKeyDetector;
import org.springframework.stereotype.Component;

@Component
public class CustomKeyDetector implements InboundEventKeyDetector<ObjectNode> {
    @Override
    public String detectEventDefinitionKey(ObjectNode event) {
        return "process-creation";
    }
}
