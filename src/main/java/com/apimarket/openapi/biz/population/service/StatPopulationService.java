package com.apimarket.openapi.biz.population.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimarket.openapi.biz.population.model.PopulationJuminSidoListVO;
import com.apimarket.openapi.biz.population.model.PopulationTrendSidoListVO;
import com.apimarket.openapi.biz.population.model.UploadStatListVO;
import com.apimarket.openapi.biz.population.repository.StatPopulationRepository;

@Service
public class StatPopulationService {

	@Autowired
	private StatPopulationRepository statPopulationRepository;
	
	public List<UploadStatListVO> getUploadStatList() {
		return statPopulationRepository.selectUploadStatList();
	}

	public List<PopulationJuminSidoListVO> getPopulationJuminSidoList(String yyyymm) {
		return statPopulationRepository.selectPopulationJuminSidoList(yyyymm);
	}
	
	public List<PopulationTrendSidoListVO> getPopulationTrendSidoList(String yyyymm) {
		return statPopulationRepository.selectPopulationTrendSidoList(yyyymm);
	}
}
