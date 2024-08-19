package com.aprender.designpatterns.methodfactory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public final class NotificationRequestDTO implements Serializable {

    private String userType;

    private String message;

}
