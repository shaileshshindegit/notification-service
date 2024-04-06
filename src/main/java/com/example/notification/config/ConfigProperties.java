package com.example.notification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "notification")
public class ConfigProperties {
    private List<Channels> channelsList;

    public static class Channels {
        private String subject;
        private String to;
        private String body;
        private String host;
    }
}
