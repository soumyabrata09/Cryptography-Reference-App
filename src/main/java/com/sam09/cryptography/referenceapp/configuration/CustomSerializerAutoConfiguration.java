package com.sam09.cryptography.referenceapp.configuration;

import com.sam09.lib.sbjacksonstarter.jackson.configuration.SerializerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(SerializerConfiguration.class)
@Configuration
public class CustomSerializerAutoConfiguration {
}
