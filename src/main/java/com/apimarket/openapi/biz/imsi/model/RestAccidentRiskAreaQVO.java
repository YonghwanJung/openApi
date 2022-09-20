package com.apimarket.openapi.biz.imsi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestAccidentRiskAreaQVO {

    //연도코드
    private String searchYearCd;

    //시도코드
    private String siDo;

    //시군구코드
    private String guGun;

    //결과형식(xml/json)
    private String type;

    //검색건수
    private long numOfRows;

    //페이지 번호
    private long pageNo;

}
