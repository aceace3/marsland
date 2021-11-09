package com.mars.marsblog.mapper;

import com.mars.marsblog.bean.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /** 查询文章列表 */
    List<ArticleVO> findAllArticle();

}
