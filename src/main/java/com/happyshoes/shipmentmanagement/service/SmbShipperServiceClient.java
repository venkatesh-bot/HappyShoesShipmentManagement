package com.happyshoes.shipmentmanagement.service;

import com.happyshoes.shipmentmanagement.data.Shipments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SmbShipperServiceClient {

    @Value("${smbShippers.url}")
    private String smbShippersUrl;

    private RestTemplate restTemplate;

    public List<Shipments> getAllShipments() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-api-key", "LqdZa4YyfRCUxM3t5N6D");
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity entity = new HttpEntity(headers);
            ResponseEntity<List<Shipments>> re = restTemplate.exchange(smbShippersUrl + "/api/shipments", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Shipments>>() {
            });
            if (re.getStatusCode() == HttpStatus.OK) {
                return re.getBody();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
