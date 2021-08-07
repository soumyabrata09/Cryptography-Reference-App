package com.sam09.cryptography.referenceapp.configuration;

import com.sam09.cryptography.referenceapp.service.IShutdownHookService;
import com.sam09.cryptography.referenceapp.service.ShutdownHookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration(proxyBeanMethods = false)
public class ShutdownConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ShutdownConfiguration.class);

    @PreDestroy
    public void onDestroy() throws Exception {
        log.info("Spring Container is Terminated");
    }

    @Bean(destroyMethod = "")
    @ConditionalOnMissingBean
    public IShutdownHookService shutdownHookService(){
        return new ShutdownHookServiceImpl();
    }
}
