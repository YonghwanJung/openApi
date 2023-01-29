package com.apimarket.openapi.biz.kostat.realestate.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatRealEstateRepository {

    private static final String MAPPER_NAME_SPACE = "mapper.StatRealEstateMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int insertStatApartSalesPriceIndex(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatApartSalesPriceIndex" , paramMap);
    }

    public int selectExistChkStatApartSalesPriceIndex(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatApartSalesPriceIndex" , yyyymm);
    }

    public int deleteStatApartSalesPriceIndex(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatApartSalesPriceIndex" , yyyymm);
    }

    public int insertStatUnsoldHousingSigungu(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatUnsoldHousingSigungu" , paramMap);
    }

    public int selectExistChkStatUnsoldHousingSigungu(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatUnsoldHousingSigungu" , yyyymm);
    }

    public int deleteStatUnsoldHousingSigungu(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatUnsoldHousingSigungu" , yyyymm);
    }

    public int insertStatBadUnsoldHousing(HashMap<String, String> paramMap) {
        return sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "insertStatBadUnsoldHousing" , paramMap);
    }

    public int selectExistChkStatBadUnsoldHousing(String yyyymm) {
        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "selectExistChkStatBadUnsoldHousing" , yyyymm);
    }

    public int deleteStatBadUnsoldHousing(String yyyymm) {
        return sqlSessionTemplate.delete(MAPPER_NAME_SPACE + "deleteStatBadUnsoldHousing" , yyyymm);
    }


}
