package com.example.notification.model.integration;

import lombok.Data;

@Data
public class ChannelNotificationRequest {
    private String notificationId;
    private String orderId;
    private String customer;
    private String email;
    private String mobile;
    private String message;
}
