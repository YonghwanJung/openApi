package com.apimarket.openapi.biz.kostat.price.controller;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apimarket.openapi.biz.kostat.price.service.PriceCpiFluctuationService;
import com.apimarket.openapi.biz.kostat.price.service.PriceCpiService;
import com.apimarket.openapi.biz.kostat.price.service.PricePpiTotalService;
import com.apimarket.openapi.config.data.Message;
import com.apimarket.openapi.config.data.StatusEnum;
import com.apimarket.openapi.config.data.YyyymmQVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/price/load")
public class StatPriceLoadController {

    @Autowired
    private PriceCpiService priceCpiService;

    @Autowired
    private PriceCpiFluctuationService priceCpiFluctuationService;

    @Autowired
    private PricePpiTotalService pricePpiTotalService;


    @RequestMapping(value = "/loadStatCpi" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatCpi(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadStatCpi");

        priceCpiService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/loadStatCpiFluctuation" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatCpiFluctuation(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadStatCpiFluctuation");

    	priceCpiFluctuationService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/loadStatPpiTotal" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatPpiTotal(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadStatPpiTotal");

    	pricePpiTotalService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}
