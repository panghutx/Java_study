package com.example.demo.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
@ConfigurationProperties("abc")
@Data
public class UserService {
    public List<String> name;
}
