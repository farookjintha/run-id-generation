package com.trizenai.runidgenerationservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a genuine @Configuration/@Bean class (Spring will create its own
 * managed ModelMapper singleton from it) — but OrderService bypasses that
 * and instantiates this class manually instead of @Autowiring the bean,
 * consistent with how this codebase generally avoids DI for its helper
 * classes (see URLBuilder, RunIdPersister, etc).
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setAmbiguityIgnored(true);
        return modelMapper;
    }
}
