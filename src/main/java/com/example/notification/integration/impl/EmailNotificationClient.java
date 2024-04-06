package com.example.notification.integration.impl;

import com.example.notification.config.ConfigProperties;
import com.example.notification.controller.NotificationController;
import com.example.notification.integration.NotificationClient;
import com.example.notification.model.integration.ChannelNotificationRequest;
import com.example.notification.model.integration.ChannelNotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        //In real life application, this method will integrate with email server and send email to recipient
        log.info("Email notification sent for Order ID : {} and notification ID : {}", request.getOrderId(), request.getNotificationId());

        return ChannelNotificationResponse.builder()
                .notificationId(request.getNotificationId())
                .orderId(request.getOrderId())
                .status("OK")
                .build();
    }

    public Boolean isChannelEnabled() {
        return isChannelEnabled;
    }
}
