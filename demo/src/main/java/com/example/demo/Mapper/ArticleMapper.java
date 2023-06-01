package com.example.demo.Mapper;

import com.example.demo.Model.T_Article;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ArticleMapper {
    
    @Select("SELECT * FROM t_article WHERE id=#{id}")
    public T_Article selectArticle(Integer id);

    @Insert("INSERT INTO t_article(author, content, type) values(#{author}, #{content}, #{type})")
    public int insertArticle(T_Article article);

    @Update("UPDATE t_article SET content=#{content} WHERE id=#{id}")
    public int updateArticle(T_Article article);

    @Delete("DELETE FROM t_article WHERE id=#{id}")
    public int deleteArticle(Integer id);
}