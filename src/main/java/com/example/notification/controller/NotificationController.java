package com.example.notification.controller;

import com.example.notification.model.ServiceNotificationRequest;
import com.example.notification.model.ServiceNotificationResponse;
import com.example.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notification")
    public ResponseEntity<ServiceNotificationResponse> sendNotification(@RequestBody ServiceNotificationRequest request) {
        log.info("Received notification request for order Id : {}", request.getOrderId());
        ServiceNotificationResponse serviceNotificationResponse = notificationService.processNotification(request);
        log.info("Notification request processed for order Id : {}", request.getOrderId());
        return new ResponseEntity<>(serviceNotificationResponse, HttpStatus.OK);
    }
}
