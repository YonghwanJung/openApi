package com.apimarket.openapi.biz.population.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apimarket.openapi.biz.population.model.UploadStatListRVO;
import com.apimarket.openapi.biz.population.model.UploadStatListVO;
import com.apimarket.openapi.biz.population.service.PopuMoveMmSidoService;
import com.apimarket.openapi.biz.population.service.PopuTrendMmSidoService;
import com.apimarket.openapi.biz.population.service.StatPopulationService;
import com.apimarket.openapi.config.data.Message;
import com.apimarket.openapi.config.data.StatusEnum;
import com.apimarket.openapi.config.data.YyyymmQVO;

@RestController
@RequestMapping(value = "/population")
public class StatPopulationController {

    @Autowired
    private PopuTrendMmSidoService popuTrendMmSidoService;
	
    @Autowired
    private StatPopulationService statPopulationService;

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
    
    @RequestMapping(value = "/uploadStatList" , method = RequestMethod.GET)
    public ResponseEntity<Message> getUploadStatList(){
    	
        System.out.println("start getUploadStatList");
        
        List<UploadStatListVO> resultSList = statPopulationService.getUploadStatList();
        List<UploadStatListRVO> resultList = new ArrayList<>();
        //BeanUtils.copyProperties(resultSList, resultList);
        
        for (int i = 0; i < resultSList.size(); i++) {
        	UploadStatListRVO resultVo = new UploadStatListRVO();
            BeanUtils.copyProperties(resultSList.get(i), resultVo);
            resultList.add(resultVo);
        }
                
        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setCode(StatusEnum.OK);
        message.setData(resultList);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}
