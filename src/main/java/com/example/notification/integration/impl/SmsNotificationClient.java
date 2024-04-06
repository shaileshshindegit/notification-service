package com.example.notification.integration.impl;

import com.example.notification.integration.NotificationClient;
import com.example.notification.model.integration.ChannelNotificationRequest;
import com.example.notification.model.integration.ChannelNotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsNotificationClient implements NotificationClient {

    //TODO: Get enable flag value from external configuration
    private Boolean isChannelEnabled = true;
    @Override
    public ChannelNotificationResponse notify(ChannelNotificationRequest request) {

        //In real life application, this method will integrate with SMTP server and send notification to SMS
        log.info("SMS notification sent for Order ID : {} and notification ID : {}", request.getOrderId(), request.getNotificationId());

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