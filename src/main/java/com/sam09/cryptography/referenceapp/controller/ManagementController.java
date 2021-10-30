/**
 * @author Soumya09
 *
 */
package com.sam09.cryptography.referenceapp.controller;

import com.sam09.cryptography.referenceapp.constants.ApplicationConstants;
import com.sam09.cryptography.referenceapp.service.IShutdownHookService;
import com.sam09.cryptography.referenceapp.service.ShowAPI;
import io.swagger.v3.oas.annotations.Hidden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = ApplicationConstants.ROOT)
@CrossOrigin(value = ApplicationConstants.CROSS_ORIGIN_VALUE)
public class ManagementController{

    private static final Logger log = LoggerFactory.getLogger(ManagementController.class);
    @Autowired
    IShutdownHookService shutdownHookService;

    @RequestMapping(method = RequestMethod.POST, value = ApplicationConstants.SHUTDOWN)
    @ResponseBody
    @ShowAPI
    public Map<String,String> initShutdownHook(){
        log.info("Shutdown Hook Initialized");
        return shutdownHookService.enableShutdownHook();
    }

}
