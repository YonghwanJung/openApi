package com.apimarket.openapi.biz.kostat.realestate.controller;

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

import com.apimarket.openapi.biz.kostat.realestate.service.ApartSalesPriceIndexService;
import com.apimarket.openapi.biz.kostat.realestate.service.BadUnsoldHousingService;
import com.apimarket.openapi.biz.kostat.realestate.service.UnsoldHousingSigunguService;
import com.apimarket.openapi.config.data.Message;
import com.apimarket.openapi.config.data.StatusEnum;
import com.apimarket.openapi.config.data.YyyymmQVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/realestate/load")
public class StatRealEstateLoadController {

    @Autowired
    private ApartSalesPriceIndexService apartSalesPriceIndexService;

    @Autowired
    private BadUnsoldHousingService badUnsoldHousingService;

    @Autowired
    private UnsoldHousingSigunguService unsoldHousingSigunguService;


    @RequestMapping(value = "/loadStatApartSalesPriceIndex" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatApartSalesPriceIndex(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadStatApartSalesPriceIndex");

    	apartSalesPriceIndexService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/loadStatBadUnsoldHousing" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatBadUnsoldHousing(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadStatBadUnsoldHousing");

    	badUnsoldHousingService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/loadStatUnsoldHousingSigungu" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatUnsoldHousingSigungu(@RequestBody YyyymmQVO yyyymmQvo){

    	System.out.println("start loadStatUnsoldHousingSigungu");

    	unsoldHousingSigunguService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}
