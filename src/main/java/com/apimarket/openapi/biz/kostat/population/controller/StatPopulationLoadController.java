package com.apimarket.openapi.biz.kostat.population.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apimarket.openapi.biz.kostat.population.model.PopulationJuminSidoListRVO;
import com.apimarket.openapi.biz.kostat.population.model.PopulationTrendSidoListRVO;
import com.apimarket.openapi.biz.kostat.population.model.UploadStatListRVO;
import com.apimarket.openapi.biz.kostat.population.service.PopuEconActiveAdjustService;
import com.apimarket.openapi.biz.kostat.population.service.PopuEconActiveSidoService;
import com.apimarket.openapi.biz.kostat.population.service.PopuMoveMmSidoService;
import com.apimarket.openapi.biz.kostat.population.service.PopuTrendMmSidoService;
import com.apimarket.openapi.biz.kostat.population.service.StatPopulationService;
import com.apimarket.openapi.config.data.Message;
import com.apimarket.openapi.config.data.StatusEnum;
import com.apimarket.openapi.config.data.YyyymmQVO;

@RestController
@RequestMapping(value = "/population/load")
public class StatPopulationLoadController {

    @Autowired
    private PopuTrendMmSidoService popuTrendMmSidoService;

    @Autowired
    private StatPopulationService statPopulationService;

    @Autowired
    private PopuEconActiveSidoService popuEconActiveSidoService;

    @Autowired
    private PopuEconActiveAdjustService popuEconActiveAdjustService;

    @Autowired
    private PopuMoveMmSidoService popuMoveMmSidoService;

    @RequestMapping(value = "/loadStatPopulationTrendSido" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatPopulationTrendSido(@RequestBody YyyymmQVO yyyymmQvo){

        System.out.println("start loadStatPopulationTrendSido");

        popuTrendMmSidoService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/loadStatPopulationMoveSido" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatPopulationMoveSido(@RequestBody YyyymmQVO yyyymmQvo) {
        System.out.println("start loadStatPopulationMoveSido");

        popuMoveMmSidoService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);

    }

    @RequestMapping(value = "/loadStatPopulationEconActiveSido" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatPopulationEconActiveSido(@RequestBody YyyymmQVO yyyymmQvo) {
        System.out.println("start loadStatPopulationEconActiveSido");

        popuEconActiveSidoService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);

    }

    @RequestMapping(value = "/loadStatPopulationEconActiveAdjst" , method = RequestMethod.POST)
    public ResponseEntity<Message> loadStatPopulationEconActiveAdjst(@RequestBody YyyymmQVO yyyymmQvo) {
        System.out.println("start StatPopulationEconActiveAdjst");

        popuEconActiveAdjustService.doFromToMonth(yyyymmQvo.getStartYyyymm(), yyyymmQvo.getEndYyyymm());
        String rt = "success";

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(rt);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);

    }


    @RequestMapping(value = "/uploadStatList" , method = RequestMethod.GET)
    public ResponseEntity<Message> getUploadStatList(){

        System.out.println("start getUploadStatList");

        List<UploadStatListRVO> resultList = statPopulationService.getUploadStatList();
        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(resultList);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/juminSidoList" , method = RequestMethod.POST)
    public ResponseEntity<Message> getJuminSidoList(@RequestBody YyyymmQVO yyyymmQvo){

        System.out.println("start getJuminSidoList");

        List<PopulationJuminSidoListRVO> resultList = statPopulationService.getPopulationJuminSidoList(yyyymmQvo.getStartYyyymm());

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(resultList);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/trendSidoList" , method = RequestMethod.POST)
    public ResponseEntity<Message> getTrendSidoList(@RequestBody YyyymmQVO yyyymmQvo){

        System.out.println("start getJuminSidoList");

        List<PopulationTrendSidoListRVO> resultList = statPopulationService.getPopulationTrendSidoList(yyyymmQvo.getStartYyyymm());

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(resultList);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

}
