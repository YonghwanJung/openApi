package com.apimarket.openapi.config.data;

import lombok.Data;

@Data
public class Message {

    private StatusEnum code;
    private String message;
    private Object data;

    public Message() {
        this.code = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }
}