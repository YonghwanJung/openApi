package com.apimarket.openapi.biz.population.model;

import lombok.Data;

@Data
public class StatPopulationMoveSidoVO {

    //연월
    private String yyyymm;

    //시도코드
    private String sidoCd;

    //총전입(명)
    private double totInCnt;

    //총전출(명)
    private double totOutCnt;

    //순이동(명)
    private double netCnt;

    //시도간전입(명)
    private double overInCnt;

    //시도간전출(명)
    private double overOutCnt;

}
