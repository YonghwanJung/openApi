package com.apimarket.openapi.biz.kostat.price.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.apimarket.openapi.biz.kostat.price.repository.StatPriceRepository;
import com.apimarket.openapi.common.service.YyyymmService;
import com.apimarket.openapi.config.aop.GlobalRestExceptionHandler;
import com.apimarket.openapi.config.exception.CommonErrorCode;
import com.apimarket.openapi.config.exception.RestApiException;
import com.apimarket.openapi.config.exception.UserErrorCode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PricePpiTotalService extends YyyymmService{

	@Autowired
	private StatPriceRepository statPriceRepository;

	public boolean doOneMonth(String yyyymm){

		try {

			int chkCnt = statPriceRepository.selectExistChkStatPpiTotal(yyyymm);

			if (chkCnt > 0) {
				statPriceRepository.deleteStatPpiTotal(yyyymm);
			}

			StringBuilder urlBuilder = new StringBuilder("https://kosis.kr/openapi/statisticsData.do?method=getList&apiKey");
			urlBuilder.append("=ZGI2MGQ1NjYxZWI5MzE5ZDkzYjUwOWQ5YThjMjU1ODI=&format=json&jsonVD=Y&userStatsId=");
			urlBuilder.append("patron84/301/DT_404Y014/2/2/20221029105154&prdSe=M"); /* URL*/

			urlBuilder.append("&startPrdDe=" + yyyymm);
			urlBuilder.append("&endPrdDe=" + yyyymm);
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code:" + conn.getResponseCode());
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

			JSONArray jsonArray = new JSONArray(result);
			// 배열의 모든 아이템을 출력합니다.
			HashMap<String, String> dataMap = new HashMap<>();

		    JSONObject obj = jsonArray.getJSONObject(0);
		    String dt = obj.getString("DT");
		    String prdDe = obj.getString("PRD_DE");
		    dataMap.put("YYYYMM", prdDe);
		    try {
		    	dataMap.put("PPI_RATE", dt);
		    } catch (Exception e) {
		    	System.out.println("skip");
		    }

		    System.out.println(dataMap.toString());
		    statPriceRepository.insertStatPpiTotal(dataMap);

		} catch (JSONException je) {
			throw new RestApiException(UserErrorCode.NO_DATA_OPENAPI);
		} catch (IOException ie) {
			throw new RestApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
		}
		return true;
	}




}
