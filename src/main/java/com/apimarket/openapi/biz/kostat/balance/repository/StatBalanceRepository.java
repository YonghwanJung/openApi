package com.apimarket.openapi.biz.kostat.balance.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatBalanceRepository {

    private static final String MAPPER_NAME_SPACE = "mapper.StatBalanceMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int insertStatTradeSummary(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatTradeSummary" , paramMap);
    }

    public int selectExistChkStatTradeSummary(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatTradeSummary" , yyyymm);
    }

    public int deleteStatTradeSummary(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatTradeSummary" , yyyymm);
    }

    public int insertStatInternationalBalance(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatInternationalBalance" , paramMap);
    }

    public int selectExistChkStatInternationalBalance(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatInternationalBalance" , yyyymm);
    }

    public int deleteStatInternationalBalance(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatInternationalBalance" , yyyymm);
    }


}
