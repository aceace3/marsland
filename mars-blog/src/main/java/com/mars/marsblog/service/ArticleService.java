package com.mars.marsblog.service;

import com.mars.marsblog.bean.vo.ArticleVO;
import com.mars.marsblog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<ArticleVO> findAllArticle(){
        return articleMapper.findAllArticle();
    }
}
