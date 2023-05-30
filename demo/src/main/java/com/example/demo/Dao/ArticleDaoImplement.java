package com.example.demo.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.T_Article;

@Repository
public class ArticleDaoImplement implements ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addArticle(T_Article t_Article) {
        return jdbcTemplate.update("INSERT INTO t_article(author, content, type) values(?, ?, ?)",
        t_Article.getAuthor(), t_Article.getContent(), t_Article.getType());
    }

    @Override
    public int updateArticle(T_Article t_Article) {
        return jdbcTemplate.update("UPDATE t_article SET content=? WHERE id=?",
        t_Article.getContent(), t_Article.getId());
    }

    @Override
    public int deleteArticle(T_Article t_Article) {
        return jdbcTemplate.update("DELETE FROM t_article WHERE id=?",
        t_Article.getId());
    }

    @Override
    public T_Article findArticleById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM t_article WHERE id=?",
        new BeanPropertyRowMapper<T_Article>(T_Article.class), new Object[]{id});
    }

    @Override
    public List<Map<String, Object>> listArticle() {
        return jdbcTemplate.queryForList("SELECT * FROM t_article");
    }
    
}
