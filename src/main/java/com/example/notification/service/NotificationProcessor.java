package com.example.notification.service;

import com.example.notification.integration.NotificationClient;
import com.example.notification.model.ServiceNotificationRequest;
import com.example.notification.model.integration.ChannelNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationProcessor {

    //TODO : Default task executor is used for simplicity. In real world applications, executor bean needs to be configured as per system load
    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private List<NotificationClient> notificationClientsList;

    public void processNotification(ServiceNotificationRequest request, String notificationId) {
        taskExecutor.execute(() -> notificationClientsList.stream()
                                    .filter(NotificationClient::isChannelEnabled)
                                    .forEach(channel -> channel.notify(buildChannelNotificationRequest(request, notificationId)))
        );
    }


    //TODO : Replace below manual mapping with Java mapping framework like mapStruct
    private ChannelNotificationRequest buildChannelNotificationRequest(ServiceNotificationRequest request, String notificationId) {
        return ChannelNotificationRequest.builder()
                .email(request.getCustomer())
                .message(request.getMessage())
                .orderId(request.getOrderId())
                .customer(request.getCustomer())
                .mobile(request.getMobile())
                .notificationId(notificationId)
                .build();
    }
}
