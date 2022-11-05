package com.apimarket.openapi.biz.kostat.economy.controller;

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

import com.apimarket.openapi.biz.kostat.economy.service.EconGeneralIndexService;
import com.apimarket.openapi.biz.kostat.price.service.PriceCpiFluctuationService;
import com.apimarket.openapi.biz.kostat.price.service.PricePpiTotalService;
import com.apimarket.openapi.config.data.Message;
import com.apimarket.openapi.config.data.StatusEnum;
import com.apimarket.openapi.config.data.YyyymmQVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/economy/load")
public class StatEconomyLoadController {

    @Autowired
    private EconGeneralIndexService econGeneralIndexService;



    @RequestMapping(value = "/loadEconGeneralIndex" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadEconGeneralIndex(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadEconGeneralIndex");

    	econGeneralIndexService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

}
