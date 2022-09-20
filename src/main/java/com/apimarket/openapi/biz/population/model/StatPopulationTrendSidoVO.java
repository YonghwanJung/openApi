package com.apimarket.openapi.biz.population.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatPopulationTrendSidoVO {

    //연월
    private String yyyymm;

    //시도코드(행정동)
    private String sido2Cd;

    //출생아수(명)
    private double birthCnt;

    //조출생율(천명당)
    private double birthRatio;

    //사망자수(명)
    private double deathCnt;

    //조사망율(천명당)
    private double deathRatio;

    //자연증가건수(명)
    private double increaseCnt;

    //자연증가율(천명당)
    private double increaseRatio;

    //혼인건수(건)
    private double marryCnt;

    //조혼인율(천명당)
    private double marryRatio;

    //이혼건수(건)
    private double divorceCnt;

    //조이혼율(천명당)
    private double divorceRatio;

    @Override
    public String toString() {
        return "StatPopulationTrendSidoVO{" +
                "yyyymm='" + yyyymm + '\'' +
                ", sido2Cd='" + sido2Cd + '\'' +
                ", birthCnt=" + birthCnt +
                ", birthRatio=" + birthRatio +
                ", deathCnt=" + deathCnt +
                ", deathRatio=" + deathRatio +
                ", increaseCnt=" + increaseCnt +
                ", increaseRatio=" + increaseRatio +
                ", marryCnt=" + marryCnt +
                ", marryRatio=" + marryRatio +
                ", divorceCnt=" + divorceCnt +
                ", divorceRatio=" + divorceRatio +
                '}';
    }
}
