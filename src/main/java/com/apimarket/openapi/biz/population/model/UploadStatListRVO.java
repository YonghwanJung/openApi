package com.apimarket.openapi.biz.population.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UploadStatListRVO {

    //통계명
    private String statName;
    
    //적재시작년월
    private String startYyyymm;
    
    //적재최종년월
    private String endYyyymm;

    //총데이터건수
    private BigDecimal totalCnt;

}
