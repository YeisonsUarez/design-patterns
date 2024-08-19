package com.aprender.designpatterns.methodfactory.service.factory;

import com.aprender.designpatterns.methodfactory.dto.NotificationRequestDTO;
import com.aprender.designpatterns.methodfactory.provider.Provider;

public abstract class Notification {

    protected abstract Provider getProvider();

    public void sendNotification(NotificationRequestDTO requestDTO){
        getProvider().sendNotification(requestDTO.getMessage());
    }
}
