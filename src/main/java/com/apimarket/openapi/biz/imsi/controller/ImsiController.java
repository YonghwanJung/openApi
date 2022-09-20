package com.apimarket.openapi.biz.imsi.controller;

import com.apimarket.openapi.biz.imsi.model.ImsiVo;
import com.apimarket.openapi.biz.imsi.model.RestAccidentRiskAreaQVO;
import com.apimarket.openapi.biz.imsi.model.RestAccidentRiskAreaRVO;
import com.apimarket.openapi.biz.imsi.repository.ImsiRepository;
import com.apimarket.openapi.biz.imsi.service.ImsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/imsi")
public class ImsiController {

    @Autowired
    private ImsiRepository imsiRepository;

    @Autowired
    private ImsiService imsiService;

    @RequestMapping(value = "/getAll" , method = RequestMethod.GET)
    public ResponseEntity<List<ImsiVo>> getAll(){
        return new ResponseEntity(imsiRepository.getImsiInfoAll() , HttpStatus.OK) ;
    }

    @RequestMapping(value = "/loadRestAccidentRiskArea" , method = RequestMethod.POST)
    public ResponseEntity<List<RestAccidentRiskAreaRVO>> loadRestAccidentRiskArea(@RequestBody RestAccidentRiskAreaQVO restAccidentRiskAreaQVO)
            throws IOException {
        System.out.println("start loadRestAccidentRiskArea");

        restAccidentRiskAreaQVO.setSearchYearCd("2017");
        restAccidentRiskAreaQVO.setSiDo("11");
        restAccidentRiskAreaQVO.setGuGun("680");
        restAccidentRiskAreaQVO.setNumOfRows(10);
        restAccidentRiskAreaQVO.setPageNo(1);

        imsiService.loadRestAccidentRiskArea(restAccidentRiskAreaQVO);
        List<RestAccidentRiskAreaRVO> result = new ArrayList<RestAccidentRiskAreaRVO>();
        return new ResponseEntity(result , HttpStatus.OK) ;
    }


}
