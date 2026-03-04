package org.springproj.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringProjConfig {

    @Bean
    String foo() {
        return new String("bar");
    }

}
