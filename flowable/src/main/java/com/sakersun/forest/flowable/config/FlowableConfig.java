package com.sakersun.forest.flowable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class FlowableConfig {

    @Bean
    Gson gson() {
        return new GsonBuilder().create();
    }
}
