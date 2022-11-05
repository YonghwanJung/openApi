package com.apimarket.openapi.biz.kostat.economy.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatEconomyRepository {

    private static final String MAPPER_NAME_SPACE = "mapper.StatEconomyMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int insertStatEconGeneralIndex(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatEconGeneralIndex" , paramMap);
    }

    public int selectExistChkStatEconGeneralIndex(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatEconGeneralIndex" , yyyymm);
    }

    public int deleteStatEconGeneralIndex(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatEconGeneralIndex" , yyyymm);
    }


}
