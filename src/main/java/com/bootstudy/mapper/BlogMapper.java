package com.bootstudy.mapper;

import com.bootstudy.modal.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BlogMapper {

    Map<String,Object> getBlog(Integer id);//根据主键获取blog信息
    List<Blog> getBlogList(Map<String,Object> dto);//批量获取
    void saveBlog(Map<String,Object> dto);//保存blog
    void deleteBlog(Map<String,Object> dto);//删除
}
