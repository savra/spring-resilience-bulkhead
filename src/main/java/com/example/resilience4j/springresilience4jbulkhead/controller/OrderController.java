package com.example.resilience4j.springresilience4jbulkhead.controller;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static final String ORDER_SERVICE ="orderService" ;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ReportRepository reportRepository;

    @Transactional
    @GetMapping("/order")
 //   @Bulkhead(name=ORDER_SERVICE,fallbackMethod = "bulkHeadFallback")
    public ResponseEntity<String> createOrder()
    {
        logger.info(LocalTime.now() + " Call processing start = " + Thread.currentThread().getName());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Отправляем запрос в HHsearch report service
       // String response = restTemplate.getForObject("http://localhost:8445/api/v1/report/test", String.class);
        //   reportRepository.test();
    //    logger.info(LocalTime.now() + " Call processing finished = " + Thread.currentThread().getName());
        return new ResponseEntity<>("", HttpStatus.OK);
    }

  /*  public ResponseEntity<String> bulkHeadFallback(Exception t)
    {
        return new ResponseEntity<String>(" orderService is full and does not permit further calls", HttpStatus.TOO_MANY_REQUESTS);
    }*/

}
