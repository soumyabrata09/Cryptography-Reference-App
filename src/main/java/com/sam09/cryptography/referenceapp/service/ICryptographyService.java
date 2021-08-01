package com.sam09.cryptography.referenceapp.service;

import com.sam09.cryptography.referenceapp.model.CryptoData;
import java.io.UnsupportedEncodingException;

/**
 * @author Soumya09
 *
 */
public interface ICryptographyService {
    CryptoData getEncryptedData(CryptoData cryptoData) throws UnsupportedEncodingException;
    CryptoData getDecryptedData(CryptoData cryptoData);
}
