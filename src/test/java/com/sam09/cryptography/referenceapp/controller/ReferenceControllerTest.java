package com.sam09.cryptography.referenceapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sam09.cryptography.referenceapp.constants.ApplicationConstants;
import com.sam09.cryptography.referenceapp.model.CryptoData;
import com.sam09.cryptography.referenceapp.utility.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReferenceControllerTest {

    private static final Logger log = LoggerFactory.getLogger(ReferenceControllerTest.class);

    private static final String base_url = ApplicationConstants.ROOT;
    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName(ApplicationConstants.CHARSET_UTF8));
    private CryptoData cryptoDataModel;
    private static final String DUMMY_NAME = "Venom09";
    private static final String DUMMY_VALUE_FOR_ENCRYPTION = "Counting all the assholes in the room, well I'm definitely not alone";
    private static final String DUMMY_VALUE_FOR_DECRYPTION = "Q291bnRpbmcgYWxsIHRoZSBhc3Nob2xlcyBpbiB0aGUgcm9vbSwgd2VsbCBJJ20gZGVmaW5pdGVseSBub3QgYWxvbmU";
    private ObjectMapper mapper;
    private ObjectWriter writer;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        cryptoDataModel = new CryptoData();
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        writer = mapper.writer().withDefaultPrettyPrinter();
    }

    @Test
    public void testEncryptionEndpoint() throws Exception {
        String encryption_url = base_url + ApplicationConstants.ENCRYPT;
        cryptoDataModel.setName(DUMMY_NAME);
        cryptoDataModel.setValue(DUMMY_VALUE_FOR_ENCRYPTION);
        String requestJSON = writer.writeValueAsString(cryptoDataModel);

        MockHttpServletRequestBuilder mockEncryptionRequest = TestUtils.mockRequestBuilder(
                encryption_url, HttpMethod.POST, APPLICATION_JSON_UTF8, requestJSON);

        this.mockMvc.perform(mockEncryptionRequest)
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void testDecryptionEndpoint() throws Exception{
        String decryption_url = base_url + ApplicationConstants.DECRYPT;
        cryptoDataModel.setName(DUMMY_NAME);
        cryptoDataModel.setValue(DUMMY_VALUE_FOR_DECRYPTION);
        String requestJSON = writer.writeValueAsString(cryptoDataModel);

        MockHttpServletRequestBuilder mockDecryptionRequest = TestUtils.mockRequestBuilder(
                decryption_url, HttpMethod.POST, APPLICATION_JSON_UTF8, requestJSON);

        this.mockMvc.perform(mockDecryptionRequest)
                .andExpect(status().is2xxSuccessful());
    }
}