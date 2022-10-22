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

    
	@RequestMapping("test")
	public String test() {
		return "This is spring";
	}
	
}
