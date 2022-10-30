package com.apimarket.openapi.biz.price.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apimarket.openapi.biz.population.model.PopulationJuminSidoListVO;
import com.apimarket.openapi.biz.population.model.PopulationTrendSidoListVO;
import com.apimarket.openapi.biz.population.model.StatPopulationMoveSidoVO;
import com.apimarket.openapi.biz.population.model.StatPopulationTrendSidoVO;
import com.apimarket.openapi.biz.population.model.UploadStatListVO;

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

}
