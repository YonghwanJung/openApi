package com.apimarket.openapi.biz.population.repository;

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
    
    public List<UploadStatListVO> selectUploadStatList() {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUploadStatList" );
    }

    public List<PopulationJuminSidoListVO> selectPopulationJuminSidoList(String yyyymm) {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectPopulationJuminSidoList" , yyyymm);
    }    

    public List<PopulationTrendSidoListVO> selectPopulationTrendSidoList(String yyyymm) {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectPopulationTrendSidoList" , yyyymm);
    }    

    
}
