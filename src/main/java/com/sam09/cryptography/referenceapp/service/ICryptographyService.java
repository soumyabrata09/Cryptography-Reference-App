package com.sam09.cryptography.referenceapp.service;

import com.sam09.cryptography.referenceapp.model.CryptoData;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;

/**
 * @author Soumya09
 *
 */
public interface ICryptographyService {
    public CryptoData getEncryptedData(CryptoData cryptoData) throws UnsupportedEncodingException;
    public CryptoData getDecryptedData(CryptoData cryptoData);
}
