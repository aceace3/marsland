package com.mars.marsblog.controller;

import com.mars.marsblog.service.ArticleService;
import com.mars.marscommons.resp.Result;
import com.mars.marscommons.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/findAllArticle")
    public Result findAllArticle(){
        return ResultUtil.success(articleService.findAllArticle());
    }

}
