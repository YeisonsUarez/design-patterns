package com.aprender.designpatterns.methodfactory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationDTO {
    private List<UserConfigurationDTO> configurations;
}
