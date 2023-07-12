package com.appcoy.school.management.api.configuration;

import com.appcoy.school.management.api.configuration.bean.Bag;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppConfiguration {
    @Value("${app.threshold.count}")
    private Integer thresholdCount;

    @Bean
    public Bag getBeanBag() {
        return new Bag(1, "tag");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Hello World!!!");
    }
}
