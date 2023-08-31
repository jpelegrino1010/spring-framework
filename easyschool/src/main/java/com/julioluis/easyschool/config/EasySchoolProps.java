package com.julioluis.easyschool.config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "easyschool")
@Data
@Validated
public class EasySchoolProps {

    @Min(value = 5,message = "must be between 5 and 25")
    @Max(value = 25,message = "must be between 5 and 25")
    private Integer pageSize;
    private Map<String,String> contact;
    private List<String> branches;
}
