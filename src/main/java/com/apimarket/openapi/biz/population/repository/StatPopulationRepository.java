package com.apimarket.openapi.biz.population.repository;

import com.apimarket.openapi.biz.population.model.StatPopulationMoveSidoVO;
import com.apimarket.openapi.biz.population.model.StatPopulationTrendSidoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatPopulationRepository {

    private static final String MAPPER_NAME_SPACE = "mapper.StatPopulationMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int insertStatPopulationTrendSido(StatPopulationTrendSidoVO statPopulationTrendSidoVO) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatPopulationTrendSido" , statPopulationTrendSidoVO);
    }

    public int selectExistChkStatPopulationTrendSido(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatPopulationTrendSido" , yyyymm);
    }

    public int deletePopulationTrendSido(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deletePopulationTrendSido" , yyyymm);
    }

    public int insertStatPopulationMoveSido(StatPopulationMoveSidoVO statPopulationMoveSidoVO) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatPopulationMoveSido" , statPopulationMoveSidoVO);
    }

    public int selectExistChkStatPopulationMoveSido(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatPopulationMoveSido" , yyyymm);
    }

    public int deletePopulationMoveSido(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deletePopulationMoveSido" , yyyymm);
    }
}
