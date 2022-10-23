package com.apimarket.openapi.biz.population.model;

import lombok.Data;

@Data
public class PopulationTrendSidoListVO {

    //시도명
    private String sidoName;
    
    //출생인구
    private String birthCnt;
    
    //사망인구
    private String deathCnt;

    //순증금인구
    private String increaseCnt;

}
