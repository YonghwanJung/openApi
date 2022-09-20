package com.apimarket.openapi.biz.imsi.repository;

import com.apimarket.openapi.biz.imsi.model.ImsiVo;
import com.apimarket.openapi.biz.imsi.model.RestAccidentRiskAreaRVO;
import com.apimarket.openapi.biz.population.model.StatPopulationTrendSidoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImsiRepository {
    private static final String MAPPER_NAME_SPACE = "mapper.imsiMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<ImsiVo> getImsiInfoAll() {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectImsiInfoAll");
    }

    public int insertAccidentRiskArea(RestAccidentRiskAreaRVO restAccidentRiskAreaRVO) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertAccidentRiskArea" ,restAccidentRiskAreaRVO);
    }


}
