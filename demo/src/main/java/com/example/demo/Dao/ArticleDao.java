package com.example.demo.Dao;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.T_Article;

public interface ArticleDao {

    int addArticle(T_Article t_Article);
    int updateArticle(T_Article t_Article);
    int deleteArticle(T_Article t_Article);
    T_Article findArticleById(Integer id);

    List<Map<String, Object>> listArticle();
}
