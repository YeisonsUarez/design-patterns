package com.aprender.designpatterns.methodfactory.common;

import java.util.Arrays;

public enum UserType {

    BASIC,
    MEDIUM,
    ADVANCED;


    public static Boolean userTypeExits(String userType){
        return Arrays.stream(UserType.values()).anyMatch(type -> userType.equalsIgnoreCase(type.name()));
    }

}
