package com.example.notification.service;

import com.example.notification.model.ServiceNotificationRequest;
import com.example.notification.model.ServiceNotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.lang.String.valueOf;

@Service
public class NotificationService {

    @Autowired
    private NotificationProcessor notificationProcessor;

    public ServiceNotificationResponse processNotification(ServiceNotificationRequest request) {

        String notificationId = valueOf(UUID.randomUUID());

        //Process notification asynchronously
        notificationProcessor.processNotification(request, notificationId);

        return ServiceNotificationResponse.builder()
                .notificationId(notificationId)
                .orderId(request.getOrderId())
                .build();
    }
}
