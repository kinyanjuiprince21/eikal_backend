package com.eikal.configurations;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Configuration
public class JacksonConfig {
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer addCustomBigDecimalDeserialization() {
//        return jacksonObjectMapperBuilder -> {
//            jacksonObjectMapperBuilder.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            jacksonObjectMapperBuilder.modules(new Hibernate5Module());
//        };
//    }
}
