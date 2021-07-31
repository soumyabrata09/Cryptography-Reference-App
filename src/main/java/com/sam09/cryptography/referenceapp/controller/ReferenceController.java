package com.sam09.cryptography.referenceapp.controller;

import com.sam09.cryptography.referenceapp.model.CryptoData;
import com.sam09.cryptography.referenceapp.service.ICryptographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;

/**
 * @author Soumya09
 *
 */

@RestController
@RequestMapping(value = "/v1")
@CrossOrigin(origins = "*")
public class ReferenceController {

    @Autowired
    ICryptographyService service;

    /*public ReferenceController(ICryptographyService service) {
        this.service = service;
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/encrypt")
    @ResponseBody
    public CompletableFuture<CryptoData> encodeData(@RequestBody CryptoData data) throws UnsupportedEncodingException {
        return CompletableFuture.completedFuture(service.getEncryptedData(data));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/decrypt")
    @ResponseBody
    public CompletableFuture<CryptoData> decodeData(@RequestBody CryptoData data){
        return CompletableFuture.completedFuture(service.getDecryptedData(data));
    }

}
