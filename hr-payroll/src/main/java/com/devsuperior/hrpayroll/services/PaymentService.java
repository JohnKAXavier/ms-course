package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    String workerHost;

    @Autowired
    RestTemplate restTemplate;

    public Payment getPayment(long workerdId, int days){
        Map<String, String> params = new HashMap<>();
        params.put("id", ""+workerdId);

        Object worker = restTemplate.getForObject(workerHost+"/workers/{id}", Object.class, params);

        return new Payment("Bob", 200.0, days);
    }
}
