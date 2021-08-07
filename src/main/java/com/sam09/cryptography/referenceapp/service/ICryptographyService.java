/**
 * @author Soumya09
 *
 */
package com.sam09.cryptography.referenceapp.service;

import com.sam09.cryptography.referenceapp.model.CryptoData;
import java.io.UnsupportedEncodingException;

public interface ICryptographyService {
    CryptoData getEncryptedData(CryptoData cryptoData) throws UnsupportedEncodingException;
    CryptoData getDecryptedData(CryptoData cryptoData);
}
