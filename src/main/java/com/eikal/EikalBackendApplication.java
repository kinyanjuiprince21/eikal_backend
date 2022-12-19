package com.eikal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @version 1.0
 */
@SpringBootApplication
public class EikalBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(EikalBackendApplication.class, args);
    }

    @Bean
    public JSR310Module jsr310Module() {
        return new JSR310Module();
    }


}