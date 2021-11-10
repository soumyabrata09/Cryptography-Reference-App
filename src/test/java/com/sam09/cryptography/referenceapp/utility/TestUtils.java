package com.sam09.cryptography.referenceapp.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class TestUtils {

    private static final Logger log = LoggerFactory.getLogger(TestUtils.class);

    public static MockHttpServletRequestBuilder mockRequestBuilder(String url, HttpMethod httpMethod,
                                                                   MediaType contentType, String requestedJson) {
        String httpMethodType = String.valueOf(httpMethod);
        MockHttpServletRequestBuilder mockedRequest;

        switch (httpMethodType) {
            case "POST":
                log.info("HTTP Method provided: " + httpMethodType);
                mockedRequest = post(url)
                        .contentType(contentType)
                        .accept(contentType)
                        .content(requestedJson);
                log.info("mockedRequest value: " + mockedRequest);
                break;
            case "GET":
                log.info("HTTP Method provided: " + httpMethodType);
                mockedRequest = get(url)
                        .contentType(contentType)
                        .accept(contentType)
                        .content(requestedJson);
                break;
            case "DELETE":
                log.info("HTTP Method provided: " + httpMethodType);
                mockedRequest = delete(url)
                        .contentType(contentType)
                        .accept(contentType)
                        .content(requestedJson);
                break;
            case "PUT":
                log.info("HTTP Method provided: " + httpMethodType);
                mockedRequest = put(url)
                        .contentType(contentType)
                        .accept(contentType)
                        .content(requestedJson);
                break;
            case "PATCH":
                log.info("HTTP Method provided: " + httpMethodType);
                mockedRequest = patch(url)
                        .contentType(contentType)
                        .accept(contentType)
                        .content(requestedJson);
                break;
            default:
                throw new RuntimeException(httpMethodType + " is not an acceptable HTTP Method");
        }
        return mockedRequest;
    }
}
