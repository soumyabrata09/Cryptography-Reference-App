/**
 * @author Soumya09
 *
 */
package com.sam09.cryptography.referenceapp.controller;

import com.sam09.cryptography.referenceapp.constants.ApplicationConstants;
import com.sam09.cryptography.referenceapp.model.CryptoData;
import com.sam09.cryptography.referenceapp.service.ICryptographyService;
import com.sam09.cryptography.referenceapp.service.ShowAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = ApplicationConstants.ROOT)
@CrossOrigin(origins = ApplicationConstants.CROSS_ORIGIN_VALUE)
public class ReferenceController {

    private static final Logger log = LoggerFactory.getLogger(ReferenceController.class);

    @Autowired
    ICryptographyService service;

    /*public ReferenceController(ICryptographyService service) {
        this.service = service;
    }*/

    @ShowAPI
    @RequestMapping(method = RequestMethod.POST,
            value = ApplicationConstants.ENCRYPT,
            consumes = "application/json")
    @ResponseBody
    public CompletableFuture<CryptoData> encodeData(@RequestBody CryptoData data) throws UnsupportedEncodingException {
        log.info("Encrypt API Called");
        return CompletableFuture.completedFuture(service.getEncryptedData(data));
    }

    @ShowAPI
    @RequestMapping(method = RequestMethod.POST,
            value = ApplicationConstants.DECRYPT,
            consumes = "application/json")
    @ResponseBody
    public CompletableFuture<CryptoData> decodeData(@RequestBody CryptoData data){
        log.info("Decrypt API Called");
        return CompletableFuture.completedFuture(service.getDecryptedData(data));
    }

}
