package com.sam09.cryptography.referenceapp.service;

import com.sam09.cryptography.referenceapp.model.CryptoData;
import com.sam09.lib.cryptographystarter.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;

public class CryptographyDataServiceImpl implements ICryptographyService{

    @Autowired
    CryptoService cryptoService;

    @Override
    public CryptoData getEncryptedData(CryptoData cryptoData) throws UnsupportedEncodingException {
        String encodedData = cryptoService.encrypt(cryptoData.getValue().getBytes());
        cryptoData.setValue(encodedData);
        return cryptoData;
    }

    @Override
    public CryptoData getDecryptedData(CryptoData cryptoData) {
        byte[] decodedDataBytes = cryptoService.decrypt(cryptoData.getValue());
        cryptoData.setValue(new String(decodedDataBytes));
        return cryptoData;
    }
}
