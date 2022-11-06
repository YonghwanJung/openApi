package com.apimarket.openapi.biz.kostat.population.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apimarket.openapi.biz.kostat.population.model.PopulationJuminSidoListRVO;
import com.apimarket.openapi.biz.kostat.population.model.PopulationMoveSidoListRVO;
import com.apimarket.openapi.biz.kostat.population.model.PopulationTrendSidoListRVO;
import com.apimarket.openapi.biz.kostat.population.model.StatPopulationMoveSidoVO;
import com.apimarket.openapi.biz.kostat.population.model.StatPopulationTrendSidoVO;
import com.apimarket.openapi.biz.kostat.population.model.UploadStatListRVO;

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

    public int insertStatPopulationEconActiveSido(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatPopulationEconActiveSido" , paramMap);
    }

    public int selectExistChkStatPopulationEconActiveSido(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatPopulationEconActiveSido" , yyyymm);
    }

    public int deleteStatPopulationEconActiveSido(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatPopulationEconActiveSidoo" , yyyymm);
    }
    public int insertStatPopulationEconActiveAdjust(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatPopulationEconActiveAdjust" , paramMap);
    }

    public int selectExistChkStatPopulationEconActiveAdjust(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatPopulationEconActiveAdjust" , yyyymm);
    }

    public int deleteStatPopulationEconActiveAdjust(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatPopulationEconActiveAdjust" , yyyymm);
    }

    public List<UploadStatListRVO> selectUploadStatList() {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUploadStatList" );
    }

    public List<PopulationJuminSidoListRVO> selectPopulationJuminSidoList(String yyyymm) {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectPopulationJuminSidoList" , yyyymm);
    }

    public List<PopulationTrendSidoListRVO> selectPopulationTrendSidoList(String yyyymm) {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectPopulationTrendSidoList" , yyyymm);
    }

    public List<PopulationMoveSidoListRVO> selectPopulationMoveSidoList(String yyyymm) {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectPopulationMoveSidoList" , yyyymm);
    }

}
