package com.example.notification.integration;

import com.example.notification.model.integration.ChannelNotificationRequest;
import com.example.notification.model.integration.ChannelNotificationResponse;

public interface NotificationClient {

    ChannelNotificationResponse notify(ChannelNotificationRequest request);

    Boolean isChannelEnabled();
}
