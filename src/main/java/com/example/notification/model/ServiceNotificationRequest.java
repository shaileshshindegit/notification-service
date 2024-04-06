package com.example.notification.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceNotificationRequest {
    private String orderId;
    private String customer;
    private String email;
    private String mobile;
    private String message;
}
