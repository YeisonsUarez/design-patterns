package com.aprender.designpatterns.methodfactory.controller;

import com.aprender.designpatterns.methodfactory.dto.NotificationRequestDTO;
import com.aprender.designpatterns.methodfactory.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/method-factory")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;


    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequestDTO request){
        //TODO: falta crear las demás clases los Provider, así como hay KvsClient y KvsService
        return notificationService.sendNotification(request);
    }
}
