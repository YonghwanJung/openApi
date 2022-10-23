package com.apimarket.openapi.biz.mustache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {



    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/stat/search")
    public String statSearch() {
        return "stat-search";
    }

    @GetMapping("/population/juminSido")
    public String populationJuminSido() {
        return "population-juminSido";
    }
    
    @GetMapping("/population/trendSido")
    public String populationTrendSido() {
        return "population-trendSido";
    }

    @GetMapping("/population/moveSido")
    public String populationMoveSido() {
        return "population-moveSido";
    }

    
	@RequestMapping("test")
	public String test() {
		return "This is spring";
	}
	
}
