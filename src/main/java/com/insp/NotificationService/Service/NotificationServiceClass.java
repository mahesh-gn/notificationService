package com.insp.NotificationService.Service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class NotificationServiceClass {
    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceClass.class);

    public void sendNotification(String message) {
        logger.info("Notification sent: {}", message);
    }
}
