package com.example.notification.model.integration;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChannelNotificationResponse {
    private String notificationId;
    private String orderId;
    private String status;
}
