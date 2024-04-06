package com.example.notification.service;

import com.example.notification.integration.NotificationClient;
import com.example.notification.model.ServiceNotificationRequest;
import com.example.notification.model.ServiceNotificationResponse;
import com.example.notification.model.integration.ChannelNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.lang.String.valueOf;

@Service
public class NotificationService {

    @Autowired
    private List<NotificationClient> notificationClientsList;

    public ServiceNotificationResponse processNotification(ServiceNotificationRequest request) {

        String notificationId = valueOf(UUID.randomUUID());

        notificationClientsList.stream()
                .filter(NotificationClient::isChannelEnabled)
                .forEach(channel -> channel.notify(buildChannelNotificationRequest(request, notificationId)));

        return ServiceNotificationResponse.builder()
                .notificationId(notificationId)
                .orderId(request.getOrderId())
                .build();
    }

   //TODO : Replace below manual mapping with Java mapping framework like mapStruct
    private ChannelNotificationRequest buildChannelNotificationRequest(ServiceNotificationRequest request, String notificationId) {
        ChannelNotificationRequest channelNotificationRequest = new ChannelNotificationRequest();
        channelNotificationRequest.setNotificationId(notificationId);
        channelNotificationRequest.setOrderId(request.getOrderId());
        channelNotificationRequest.setMobile(request.getMobile());
        channelNotificationRequest.setMessage(request.getMessage());
        channelNotificationRequest.setCustomer(request.getCustomer());

        return channelNotificationRequest;
    }
}
