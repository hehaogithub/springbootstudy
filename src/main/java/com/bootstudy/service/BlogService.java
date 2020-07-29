package com.bootstudy.service;
import com.bootstudy.mapper.BlogMapper;
import com.bootstudy.modal.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogService {
    @Autowired
    BlogMapper blogMapper;
    public Map<String, Object> getBlog(Integer id){
       return  blogMapper.getBlog(id);
    }
    public List<Blog> getBlogList(Map<String,Object> dto){
        return  blogMapper.getBlogList(dto);
    }
    public void saveBlog(Map<String,Object> dto){
         blogMapper.saveBlog(dto);
    }
    public void deleteBlog(Map<String,Object> dto){
        blogMapper.deleteBlog(dto);
    }
}
