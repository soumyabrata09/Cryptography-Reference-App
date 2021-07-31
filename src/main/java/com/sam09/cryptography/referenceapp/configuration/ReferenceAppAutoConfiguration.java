package com.sam09.cryptography.referenceapp.configuration;

import com.sam09.cryptography.referenceapp.service.CryptographyDataServiceImpl;
import com.sam09.cryptography.referenceapp.service.ICryptographyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass
public class ReferenceAppAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ICryptographyService service(){
        return new CryptographyDataServiceImpl();
    }
}
