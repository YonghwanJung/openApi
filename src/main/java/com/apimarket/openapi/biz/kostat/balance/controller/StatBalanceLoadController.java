package com.apimarket.openapi.biz.kostat.balance.controller;

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

import com.apimarket.openapi.biz.kostat.balance.service.InternationalBalanceService;
import com.apimarket.openapi.biz.kostat.balance.service.TradeSummaryService;
import com.apimarket.openapi.config.data.Message;
import com.apimarket.openapi.config.data.StatusEnum;
import com.apimarket.openapi.config.data.YyyymmQVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/balance/load")
public class StatBalanceLoadController {

    @Autowired
    private TradeSummaryService tradeSummaryService;

    @Autowired
    private InternationalBalanceService internationalBalanceService;

    @RequestMapping(value = "/loadStatTradeSummary" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatTradeSummary(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadStatCpi");

    	tradeSummaryService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/loadStatInternationalBalance" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatInternationalBalance(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadStatCpi");

    	internationalBalanceService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}
