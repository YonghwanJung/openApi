package com.apimarket.openapi.common.service;

import org.springframework.util.StringUtils;

import com.apimarket.openapi.common.util.StringUtil;
import com.apimarket.openapi.config.exception.RestApiException;
import com.apimarket.openapi.config.exception.UserErrorCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class YyyymmService {

	abstract public boolean doOneMonth(String yyyymm);

	public void doFromToMonth(String sYyyymm, String eYyyymm) {
		if (StringUtils.hasText(sYyyymm) && StringUtils.hasText(eYyyymm) && sYyyymm.length() == 6
				&& eYyyymm.length() == 6) {

			int sYyyy = 0;
			int eYyyy = 0;
			int sMm = 0;
			int eMm = 0;
			int nowYyyy = 0;
			int nowMm = 0;
			String yyyymm = "";
			try {
				sYyyy = Integer.parseInt(sYyyymm.substring(0, 4));
				eYyyy = Integer.parseInt(eYyyymm.substring(0, 4));
				sMm = Integer.parseInt(sYyyymm.substring(4, 6));
				eMm = Integer.parseInt(eYyyymm.substring(4, 6));
			} catch (Exception e) {
				throw new RestApiException(UserErrorCode.INVALID_DATE_FORMAT);
			}

			if (sMm < 1 || sMm > 12 || eMm < 1 || eMm > 12 || sYyyy <= 1900 || eYyyy <= 1900)
				throw new RestApiException(UserErrorCode.INVALID_DATE_FORMAT);

			nowYyyy = sYyyy;
			nowMm = sMm;

			for(int i = 0 ; i < 360 ; i++) {
				yyyymm = StringUtil.lpad(nowYyyy, 4, "0") + StringUtil.lpad(nowMm, 2, "0");
				log.debug("doFromToMonth yyyymm : {}" ,yyyymm);
				System.out.println("doFromToMonth yyyymm :{}" + yyyymm);

				if (yyyymm.length() != 6)
					throw new RestApiException(UserErrorCode.INVALID_DATE_FORMAT);

				// 월별 실행
				doOneMonth(yyyymm);

				// 종료 체크 후 중단
				if(nowYyyy >= eYyyy && nowMm >= eMm) break;

				if(nowMm < 12) {
					nowMm ++;
				} else {
					nowYyyy ++;
					nowMm = 1;
				}

			}


		} else {
			throw new RestApiException(UserErrorCode.INVALID_DATE_FORMAT);
		}
	}

}
