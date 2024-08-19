package com.aprender.designpatterns.methodfactory.service.factory;

import com.aprender.designpatterns.methodfactory.provider.EmailProvider;
import com.aprender.designpatterns.methodfactory.provider.Provider;

public class EmailNotification extends Notification{
    @Override
    public Provider getProvider() {
        return new EmailProvider();
    }
}
