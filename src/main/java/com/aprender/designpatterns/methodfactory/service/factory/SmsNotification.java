package com.aprender.designpatterns.methodfactory.service.factory;

import com.aprender.designpatterns.methodfactory.provider.Provider;
import com.aprender.designpatterns.methodfactory.provider.SMSProvider;

public class SmsNotification extends Notification{
    @Override
    public Provider getProvider() {
        return new SMSProvider();
    }
}
