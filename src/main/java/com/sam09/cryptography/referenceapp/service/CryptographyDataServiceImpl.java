package com.sam09.cryptography.referenceapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam09.cryptography.referenceapp.model.CryptoData;
import com.sam09.lib.cryptographystarter.service.CryptoService;
import com.sam09.lib.sbjacksonstarter.jackson.configuration.SerializerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.UnsupportedEncodingException;

public class CryptographyDataServiceImpl implements ICryptographyService{

    private static final Logger log = LoggerFactory.getLogger(CryptographyDataServiceImpl.class);

    @Autowired
    CryptoService cryptoService;
    /*private ObjectMapper objectMapper;*/

    @Override
    public CryptoData getEncryptedData(CryptoData cryptoData) throws UnsupportedEncodingException {
        String encodedData = cryptoService.encrypt(cryptoData.getValue().getBytes());
        log.info("Encoded Data: " + encodedData);
        cryptoData.setValue(encodedData);
        return cryptoData;
    }

    @Override
    public CryptoData getDecryptedData(CryptoData cryptoData) {
        byte[] decodedDataBytes = cryptoService.decrypt(cryptoData.getValue());
        cryptoData.setValue(new String(decodedDataBytes));
        log.info("Decoded Data: " + cryptoData.getValue());
        return cryptoData;
    }

    /*public void checkingObjectMapper(){
        ObjectMapp
    }*/
}
