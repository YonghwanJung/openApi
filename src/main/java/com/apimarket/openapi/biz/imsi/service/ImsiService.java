package com.apimarket.openapi.biz.imsi.service;

import com.apimarket.openapi.biz.imsi.model.RestAccidentRiskAreaQVO;
import com.apimarket.openapi.biz.imsi.model.RestAccidentRiskAreaRVO;
import com.apimarket.openapi.biz.imsi.repository.ImsiRepository;
import com.apimarket.openapi.biz.kostat.population.model.StatPopulationTrendSidoVO;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;


@Service
public class ImsiService {
    @Autowired
    private ImsiRepository imsiRepository;

    public void loadRestAccidentRiskArea( RestAccidentRiskAreaQVO restAccidentRiskAreaQVO)
            throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552061/accidentRiskArea/getRestAccidentRiskArea"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=sn5oxNouL%2FM%2BQhK02jmZu8MCtLQRb2Lk0%2BfpMG7mtlnUAIfC5y2bqtYRuLUsWcgSCsG1TeMLvTv46nMRmM19Tg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("searchYearCd", "UTF-8")
                + "=" + URLEncoder.encode(restAccidentRiskAreaQVO.getSearchYearCd(), "UTF-8")); /*검색을 원하는 연도*/
        urlBuilder.append("&" + URLEncoder.encode("siDo", "UTF-8")
                + "=" + URLEncoder.encode(restAccidentRiskAreaQVO.getSiDo(), "UTF-8")); /*법정동 시도 코드*/
        urlBuilder.append("&" + URLEncoder.encode("guGun", "UTF-8")
                + "=" + URLEncoder.encode(restAccidentRiskAreaQVO.getGuGun(), "UTF-8")); /*법정동 시군구 코드*/
        urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8")
                + "=" + URLEncoder.encode("json", "UTF-8")); /*결과형식(xml/json)*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8")
                + "=" + URLEncoder.encode(String.valueOf(restAccidentRiskAreaQVO.getNumOfRows()), "UTF-8")); /*검색건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8")
                + "=" + URLEncoder.encode(String.valueOf(restAccidentRiskAreaQVO.getPageNo()), "UTF-8")); /*페이지 번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        String result = sb.toString();

        JSONObject jObject = new JSONObject(result);
        JSONArray item = jObject.getJSONObject("items").getJSONArray("item");
        RestAccidentRiskAreaRVO restAccidentRiskAreaRVO;
        // 배열의 모든 아이템을 출력합니다.
        for (int i = 0; i < item.length(); i++) {
            JSONObject obj = item.getJSONObject(i);
            restAccidentRiskAreaRVO = new RestAccidentRiskAreaRVO();
            restAccidentRiskAreaRVO.setAcc_risk_area_nm(obj.getString("acc_risk_area_nm"));
            restAccidentRiskAreaRVO.setTot_acc_cnt(obj.getLong("tot_acc_cnt"));
            restAccidentRiskAreaRVO.setTot_dth_dnv_cnt(obj.getLong("tot_dth_dnv_cnt"));
            restAccidentRiskAreaRVO.setTot_se_dnv_cnt(obj.getLong("tot_se_dnv_cnt"));
            restAccidentRiskAreaRVO.setTot_sl_dnv_cnt(obj.getLong("tot_sl_dnv_cnt"));
            restAccidentRiskAreaRVO.setTot_wnd_dnv_cnt(obj.getLong("tot_wnd_dnv_cnt"));
            restAccidentRiskAreaRVO.setCause_anals_ty_nm(obj.get("cause_anals_ty_nm").toString());
            restAccidentRiskAreaRVO.setCntpnt_utmk_x_crd(obj.get("cntpnt_utmk_x_crd").toString());
            restAccidentRiskAreaRVO.setCntpnt_utmk_y_crd(obj.get("cntpnt_utmk_y_crd").toString());
            //restAccidentRiskAreaRVO.setGeom_wkt(obj.getString("geom_wkt"));
            imsiRepository.insertAccidentRiskArea(restAccidentRiskAreaRVO);
        }
    }

}
