package com.aprender.designpatterns.methodfactory.service.factory;

import com.aprender.designpatterns.methodfactory.provider.Provider;
import com.aprender.designpatterns.methodfactory.provider.PushProvider;

public class PushNotification extends Notification {

    @Override
    public Provider getProvider() {
        return new PushProvider();
    }
}
