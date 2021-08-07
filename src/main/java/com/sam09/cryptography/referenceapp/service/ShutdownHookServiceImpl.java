package com.sam09.cryptography.referenceapp.service;

import com.sam09.cryptography.referenceapp.constants.ApplicationConstants;
import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class ShutdownHookServiceImpl implements IShutdownHookService, ApplicationContextAware {

    private ConfigurableApplicationContext configurableApplicationContext;

    private static final Map<String,String> NO_CONTEXT_MSG = Collections.unmodifiableMap(
            Collections.singletonMap(ApplicationConstants.MESSAGE,ApplicationConstants.NO_CTX_MSG_VAL));

    private static final Map<String,String> SHUTDOWN_MESSAGE = Collections.unmodifiableMap(
            Collections.singletonMap(ApplicationConstants.MESSAGE,ApplicationConstants.SHUTDOWN_MSG_VAL));

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(applicationContext instanceof ConfigurableApplicationContext){
            this.configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        }
    }

    @Override
    @WriteOperation
    public Map<String, String> enableShutdownHook() {
        if(this.configurableApplicationContext == null){
            return NO_CONTEXT_MSG;
        }
        try {
            return SHUTDOWN_MESSAGE;
        }
        finally {
            Thread t = new Thread(this::initiateShutdownProcess);
            t.setContextClassLoader(getClass().getClassLoader());
            t.start();
        }
    }

    private void initiateShutdownProcess() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.configurableApplicationContext.close();
    }
}
