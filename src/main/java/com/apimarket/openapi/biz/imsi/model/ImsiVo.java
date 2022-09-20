package com.apimarket.openapi.biz.imsi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImsiVo {
    private String key1;

    private String item1;

    private String item2;

    public ImsiVo(String key1, String item1, String item2) {
        this.key1 = key1;
        this.item1 = item1;
        this.item2 = item2;
    }

}
