package com.example.notification.integration.impl;

import com.example.notification.config.ConfigProperties;
import com.example.notification.integration.NotificationClient;
import com.example.notification.model.integration.ChannelNotificationRequest;
import com.example.notification.model.integration.ChannelNotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailNotificationClient implements NotificationClient {

    @Autowired
    private ConfigProperties config;

    //TODO: Get enable flag value from external configuration
    private Boolean isChannelEnabled = true;
    @Override
    public ChannelNotificationResponse notify(ChannelNotificationRequest request) {
        //In real world application, this method will integrate with email server and send email to recipient
        log.info("Email notification sent for Order ID : {} and notification ID : {}", request.getOrderId(), request.getNotificationId());

        return ChannelNotificationResponse.builder()
                .notificationId(request.getNotificationId())
                .orderId(request.getOrderId())
                .status("OK")
                .build();

        //TODO : Exception handling is not done. In real world, log exception and retry sending notification.
        // Retry can be done by using resiliency4j library
        // If retry failed say for three attempts, save notification in persistent store like DB so that those notification would be processed manually if required
    }

    public Boolean isChannelEnabled() {
        return isChannelEnabled;
    }
}
