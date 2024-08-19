package com.aprender.designpatterns.methodfactory.service;

import com.aprender.designpatterns.methodfactory.common.Constant;
import com.aprender.designpatterns.methodfactory.common.UserType;
import com.aprender.designpatterns.methodfactory.dto.ConfigurationDTO;
import com.aprender.designpatterns.methodfactory.dto.NotificationRequestDTO;
import com.aprender.designpatterns.methodfactory.dto.UserConfigurationDTO;
import com.aprender.designpatterns.methodfactory.service.factory.EmailNotification;
import com.aprender.designpatterns.methodfactory.service.factory.Notification;
import com.aprender.designpatterns.methodfactory.service.factory.PushNotification;
import com.aprender.designpatterns.methodfactory.service.factory.SmsNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService implements Constant {

    private final ConfigurationDTO configurationDTO;


    public ResponseEntity<String> sendNotification(NotificationRequestDTO message) {
        if (UserType.userTypeExits(message.getUserType())) {
            List<Notification> notifications = getNotificationByUserType(
                    UserType.valueOf(message.getUserType().toUpperCase(Locale.ROOT))
            );
            notifications.forEach(provider -> provider.sendNotification(message));
            return ResponseEntity.ok("Sent!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid usertype");
        }
    }

    public List<Notification> getNotificationByUserType(UserType userType){
        List<Notification> notifications = new ArrayList<>();

        Optional<List<String>> selectedNotificationProviders = configurationDTO.getConfigurations().stream()
                .filter(configurationDTO-> configurationDTO.getUserType().equals(userType.name()))
                .map(UserConfigurationDTO::getNotifications)
                .findFirst();

        selectedNotificationProviders.ifPresent(strings -> strings.forEach(item -> {
            switch (item){
                case EMAIL_NOTIFICATION -> notifications.add(new EmailNotification());
                case SMS_NOTIFICATION -> notifications.add(new SmsNotification());
                case PUSH_NOTIFICATION -> notifications.add(new PushNotification());
                default -> throw new IllegalStateException("Unexpected value: ".concat(item));
            }
        }));

        return notifications;

    }

}
