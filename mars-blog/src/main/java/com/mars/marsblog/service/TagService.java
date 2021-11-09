package com.mars.marsblog.service;

import com.mars.marsblog.bean.Tag;
import com.mars.marsblog.mapper.TagMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public Tag getTagByArticleId(Integer articleId){
        return tagMapper.getTagByArticleId(articleId);
    }

    public int updateTag(Tag tag){
        return tagMapper.updateTag(tag);
    }

    public int addTag(Tag tag){
        return tagMapper.addTag(tag);
    }
}
