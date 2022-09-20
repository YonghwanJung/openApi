package com.apimarket.openapi.biz.population.controller;

import com.apimarket.openapi.biz.population.model.StatPopulationMoveSidoQVO;
import com.apimarket.openapi.biz.population.model.StatPopulationTrendSidoQVO;
import com.apimarket.openapi.biz.population.repository.StatPopulationRepository;
import com.apimarket.openapi.biz.population.service.StatPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/imsi")
public class StatPopulationController {

    @Autowired
    private StatPopulationRepository statPopulationRepository;

    @Autowired
    private StatPopulationService statPopulationService;

    @RequestMapping(value = "/loadStatPopulationTrendSido" , method = RequestMethod.POST)
    @ResponseBody
    public String loadStatPopulationTrendSido(@RequestBody StatPopulationTrendSidoQVO statPopulationTrendSidoQVO)
            throws IOException {
        System.out.println("start loadStatPopulationTrendSido");

        statPopulationService.uploadStatPopulationTrendSido(statPopulationTrendSidoQVO.getYyyymm());
        String rt = "success";

        return rt;
    }

    @RequestMapping(value = "/loadStatPopulationMoveSido" , method = RequestMethod.POST)
    @ResponseBody
    public String loadStatPopulationMoveSido(@RequestBody StatPopulationMoveSidoQVO statPopulationMoveSidoQVO)
            throws IOException {
        System.out.println("start loadStatPopulationMoveSido");

        statPopulationService.uploadStatPopulationMoveSido(statPopulationMoveSidoQVO.getYyyymm());
        String rt = "success";

        return rt;
    }
}
