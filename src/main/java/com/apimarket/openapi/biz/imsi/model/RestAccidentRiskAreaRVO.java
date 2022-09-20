package com.apimarket.openapi.biz.imsi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestAccidentRiskAreaRVO {

    //keyindex
    private long keyindex;

    //API호출 결과 코드
    private String resultCode;

    //API호출 결과 메시지
    private String resultMsg;

    //사고위험지역명
    private String acc_risk_area_nm;

    //총사고건수
    private long tot_acc_cnt;

    //검색건수
    private long tot_dth_dnv_cnt;

    //총중상자수
    private long tot_se_dnv_cnt;

    //총경상자수
    private long tot_sl_dnv_cnt;

    //총부상신고자수
    private long tot_wnd_dnv_cnt;

    //사고분석유형명
    private String cause_anals_ty_nm;

    //중심점UTMK X좌표
    private String cntpnt_utmk_x_crd;

    //중심점UTMK Y좌표
    private String cntpnt_utmk_y_crd;

    //사고위험지역 폴리곤
    private String geom_wkt;

    //총건수
    private long totalCount;

    //검색건수
    private long numOfRows;

    //페이지 번호
    private long pageNo;

}
