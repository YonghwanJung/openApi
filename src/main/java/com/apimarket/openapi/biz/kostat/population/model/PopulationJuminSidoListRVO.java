package com.apimarket.openapi.biz.kostat.population.model;

import lombok.Data;

@Data
public class PopulationJuminSidoListRVO {

    //시도명
    private String sidoName;
    
    //총인구
    private String totCnt;
    
    //전월대비인구증감
    private String diffMonthTotCnt;

    //전월대비인구증감비
    private String ratioMonthTotCnt;

    //전년대비인구증감
    private String diffYearTotCnt;
    
    //전년대비인구증감비
    private String ratioYearTotCnt;

}
