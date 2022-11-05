package com.apimarket.openapi.biz.kostat.economy.service;

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

import com.apimarket.openapi.biz.kostat.economy.repository.StatEconomyRepository;
import com.apimarket.openapi.common.service.YyyymmService;
import com.apimarket.openapi.config.exception.CommonErrorCode;
import com.apimarket.openapi.config.exception.RestApiException;
import com.apimarket.openapi.config.exception.UserErrorCode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EconGeneralIndexService extends YyyymmService{

	@Autowired
	private StatEconomyRepository statEconomyRepository;

	public boolean doOneMonth(String yyyymm){

		try {

			int chkCnt = statEconomyRepository.selectExistChkStatEconGeneralIndex(yyyymm);

			if (chkCnt > 0) {
				statEconomyRepository.deleteStatEconGeneralIndex(yyyymm);
			}

			StringBuilder urlBuilder = new StringBuilder("https://kosis.kr/openapi/statisticsData.do?"
					+ "method=getList&apiKey=ZGI2MGQ1NjYxZWI5MzE5ZDkzYjUwOWQ5YThjMjU1ODI=&format=json"
					+ "&jsonVD=Y&userStatsId=patron84/101/DT_1C8013/2/2/20221029111213&prdSe=M");

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

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				String c1 = obj.getString("C1");
				String dt = obj.getString("DT");
				String prdDe = obj.getString("PRD_DE");
				dataMap.put("YYYYMM", prdDe);
				dataMap.put("ECON_INDEX_ITEM_CD", c1);
				dataMap.put("ECON_INDEX",dt);
				System.out.println(dataMap.toString());
				statEconomyRepository.insertStatEconGeneralIndex(dataMap);

			}
		} catch (JSONException je) {
			throw new RestApiException(UserErrorCode.NO_DATA_OPENAPI);
		} catch (IOException ie) {
			throw new RestApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
		}
		return true;
	}




}
