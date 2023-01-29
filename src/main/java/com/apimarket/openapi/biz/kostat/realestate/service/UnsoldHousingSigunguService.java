package com.apimarket.openapi.biz.kostat.realestate.service;

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

import com.apimarket.openapi.biz.kostat.realestate.repository.StatRealEstateRepository;
import com.apimarket.openapi.common.service.YyyymmService;
import com.apimarket.openapi.config.exception.CommonErrorCode;
import com.apimarket.openapi.config.exception.RestApiException;
import com.apimarket.openapi.config.exception.UserErrorCode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UnsoldHousingSigunguService extends YyyymmService{

	@Autowired
	private StatRealEstateRepository statRealEstateRepository;

	public boolean doOneMonth(String yyyymm){

		try {

			int chkCnt = statRealEstateRepository.selectExistChkStatUnsoldHousingSigungu(yyyymm);

			if (chkCnt > 0) {
				statRealEstateRepository.deleteStatUnsoldHousingSigungu(yyyymm);
			}

			StringBuilder urlBuilder = new StringBuilder("https://kosis.kr/openapi/statisticsData.do?method=getList&apiKey");
			urlBuilder.append("=ZGI2MGQ1NjYxZWI5MzE5ZDkzYjUwOWQ5YThjMjU1ODI=&format=json&jsonVD=Y&userStatsId=");
			urlBuilder.append("patron84/116/DT_MLTM_2082/2/2/20230125235913&prdSe=M"); /* URL*/

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
				String c1Nm = obj.getString("C1_NM");
				String c2Nm = obj.getString("C2_NM");
				String dt = obj.getString("DT");
				String prdDe = obj.getString("PRD_DE");

				dataMap.put("YYYYMM", prdDe);
				dataMap.put("SIDO_NM", c1Nm);
				dataMap.put("SIGUNGU_NM", c2Nm);
				dataMap.put("INDEX", dt);

				System.out.println(dataMap.toString());
				statRealEstateRepository.insertStatUnsoldHousingSigungu(dataMap);

			}


		} catch (JSONException je) {
			throw new RestApiException(UserErrorCode.NO_DATA_OPENAPI);
		} catch (IOException ie) {
			throw new RestApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
		}
		return true;
	}




}
