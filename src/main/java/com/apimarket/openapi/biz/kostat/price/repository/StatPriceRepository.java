package com.apimarket.openapi.biz.kostat.price.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatPriceRepository {

    private static final String MAPPER_NAME_SPACE = "mapper.StatPriceMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int insertStatCpiForLiving(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatCpiForLiving" , paramMap);
    }

    public int selectExistChkStatCpiForLiving(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatCpiForLiving" , yyyymm);
    }

    public int deleteStatCpiForLiving(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatCpiForLiving" , yyyymm);
    }

    public int insertStatCpiFluctuation(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatCpiFluctuation" , paramMap);
    }

    public int selectExistChkStatCpiFluctuation(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatCpiFluctuation" , yyyymm);
    }

    public int deleteStatCpiFluctuation(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatCpiFluctuation" , yyyymm);
    }

    public int insertStatPpiTotal(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatPpiTotal" , paramMap);
    }

    public int selectExistChkStatPpiTotal(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatPpiTotal" , yyyymm);
    }

    public int deleteStatPpiTotal(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatPpiTotal" , yyyymm);
    }

}
