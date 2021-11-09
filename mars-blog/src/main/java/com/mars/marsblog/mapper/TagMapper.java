package com.mars.marsblog.mapper;

import com.mars.marsblog.bean.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagMapper {

    Tag getTagByArticleId(@Param("articleId") Integer articleId);

    int updateTag(Tag tag);

    int addTag(Tag tag);
}
