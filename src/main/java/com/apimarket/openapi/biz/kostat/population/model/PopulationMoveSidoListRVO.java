package com.apimarket.openapi.biz.kostat.population.model;

import lombok.Data;

@Data
public class PopulationMoveSidoListRVO {

    //시도명
    private String sidoName;

    //순이동
    private String netCnt;

    //총전입
    private String totInCnt;

    //총전출
    private String totOutCnt;

    //시도간전입
    private String overInCnt;

    //시도간전출
    private String overOutCnt;


}
