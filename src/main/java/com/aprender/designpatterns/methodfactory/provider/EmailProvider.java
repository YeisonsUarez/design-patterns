package com.aprender.designpatterns.methodfactory.provider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailProvider implements Provider {
    @Override
    public void sendNotification(String message) {
        log.info("EMAIL notification sent. [msg:%s]".formatted(message));
    }
}
