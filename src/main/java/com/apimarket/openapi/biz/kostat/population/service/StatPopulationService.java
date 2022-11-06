package com.apimarket.openapi.biz.kostat.population.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimarket.openapi.biz.kostat.population.model.PopulationJuminSidoListRVO;
import com.apimarket.openapi.biz.kostat.population.model.PopulationMoveSidoListRVO;
import com.apimarket.openapi.biz.kostat.population.model.PopulationTrendSidoListRVO;
import com.apimarket.openapi.biz.kostat.population.model.UploadStatListRVO;
import com.apimarket.openapi.biz.kostat.population.repository.StatPopulationRepository;

@Service
public class StatPopulationService {

	@Autowired
	private StatPopulationRepository statPopulationRepository;

	public List<UploadStatListRVO> getUploadStatList() {
		return statPopulationRepository.selectUploadStatList();
	}

	public List<PopulationJuminSidoListRVO> getPopulationJuminSidoList(String yyyymm) {
		return statPopulationRepository.selectPopulationJuminSidoList(yyyymm);
	}

	public List<PopulationTrendSidoListRVO> getPopulationTrendSidoList(String yyyymm) {
		return statPopulationRepository.selectPopulationTrendSidoList(yyyymm);
	}

	public List<PopulationMoveSidoListRVO> getPopulationMoveSidoList(String yyyymm) {
		return statPopulationRepository.selectPopulationMoveSidoList(yyyymm);
	}
}
