package com.apimarket.openapi.config.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    INACTIVE_USER(HttpStatus.FORBIDDEN, "User is inactive"),
    NO_DATA_OPENAPI(HttpStatus.INTERNAL_SERVER_ERROR, "호출한 Open Api에 결과 DATA가 없습니다."),
    INVALID_DATE_FORMAT(HttpStatus.INTERNAL_SERVER_ERROR, "Api 요청 날짜 형식이 맞지 않습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
