package com.aprender.designpatterns.methodfactory.provider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SMSProvider implements Provider {
    @Override
    public void sendNotification(String message) {
        log.info("SMS notification sent. [msg:%s]".formatted(message));
    }
}
