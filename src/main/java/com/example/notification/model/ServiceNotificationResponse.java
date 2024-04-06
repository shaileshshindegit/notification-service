package com.example.notification.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceNotificationResponse {
    private String notificationId;
    private String orderId;
}
