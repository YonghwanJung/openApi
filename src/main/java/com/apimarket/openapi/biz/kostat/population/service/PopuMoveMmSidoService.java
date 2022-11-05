package com.apimarket.openapi.biz.kostat.population.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.apimarket.openapi.biz.kostat.population.model.StatPopulationMoveSidoVO;
import com.apimarket.openapi.biz.kostat.population.model.StatPopulationTrendSidoVO;
import com.apimarket.openapi.biz.kostat.population.repository.StatPopulationRepository;
import com.apimarket.openapi.common.service.YyyymmService;
import com.apimarket.openapi.config.exception.CommonErrorCode;
import com.apimarket.openapi.config.exception.RestApiException;
import com.apimarket.openapi.config.exception.UserErrorCode;

@Service
public class PopuMoveMmSidoService extends YyyymmService {

	@Autowired
	private StatPopulationRepository statPopulationRepository;

	public boolean doOneMonth(String yyyymm) {

		try {

			int chkCnt = statPopulationRepository.selectExistChkStatPopulationMoveSido(yyyymm);

			if (chkCnt > 0) {
				statPopulationRepository.deletePopulationMoveSido(yyyymm);
			}

			StringBuilder urlBuilder = new StringBuilder(
					"https://kosis.kr/openapi/statisticsData.do?method=getList&apiKey=ZGI2MGQ1NjYxZWI5MzE5ZDkzYjUwOWQ5YThjMjU1ODI=&format=json&jsonVD=Y&userStatsId=patron84/101/DT_1B26001_A01/2/1/20220918115243&prdSe=M"); /*
																																																								 * URL
																																																								 */
			urlBuilder.append("&startPrdDe=" + yyyymm);
			urlBuilder.append("&endPrdDe=" + yyyymm);
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

			JSONArray jsonArray = new JSONArray(result);
			// 배열의 모든 아이템을 출력합니다.
			String orgC1 = "";
			StatPopulationMoveSidoVO statPopulationMoveSidoVO = new StatPopulationMoveSidoVO();

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				String c1 = obj.getString("C1");
				String itmId = obj.getString("ITM_ID");
				String dt = obj.getString("DT");
				String prdDe = obj.getString("PRD_DE");
				if (StringUtils.isEmpty(orgC1)) {
					orgC1 = c1;
					statPopulationMoveSidoVO.setYyyymm(prdDe);
					statPopulationMoveSidoVO.setSidoCd(c1);
				}
				if (StringUtils.equals(orgC1, c1) == false) {
					System.out.println(statPopulationMoveSidoVO.toString());
					statPopulationRepository.insertStatPopulationMoveSido(statPopulationMoveSidoVO);
					orgC1 = c1;
					statPopulationMoveSidoVO = new StatPopulationMoveSidoVO();
					statPopulationMoveSidoVO.setYyyymm(prdDe);
					statPopulationMoveSidoVO.setSidoCd(c1);
				}
				try {
					if ("T10".equals(itmId)) {
						statPopulationMoveSidoVO.setTotInCnt(Double.parseDouble(dt));
					} else if ("T20".equals(itmId)) {
						statPopulationMoveSidoVO.setTotOutCnt(Double.parseDouble(dt));
					} else if ("T25".equals(itmId)) {
						statPopulationMoveSidoVO.setNetCnt(Double.parseDouble(dt));
					} else if ("T40".equals(itmId)) {
						statPopulationMoveSidoVO.setOverInCnt(Double.parseDouble(dt));
					} else if ("T50".equals(itmId)) {
						statPopulationMoveSidoVO.setOverOutCnt(Double.parseDouble(dt));
					}
				} catch (Exception e) {
					System.out.println("skip");
				}

				if (i == (jsonArray.length() - 1)) {
					System.out.println(statPopulationMoveSidoVO.toString());
					statPopulationRepository.insertStatPopulationMoveSido(statPopulationMoveSidoVO);
				}

			}
		} catch (JSONException je) {
			throw new RestApiException(UserErrorCode.NO_DATA_OPENAPI);
		} catch (IOException ie) {
			throw new RestApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
		}
		
		return true;
	}

}
