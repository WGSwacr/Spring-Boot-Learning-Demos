package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.ArticleDaoImplement;
import com.example.demo.Mapper.ArticleMapper;
import com.example.demo.Model.T_Article;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/article")
public class Article {

    @Autowired
    private ArticleDaoImplement articleDaoImplement;

    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("/test")
    @ResponseBody
    public T_Article articleTest() {
        return null;
    }
    
    @GetMapping("/list")
    public String articleList(ModelMap map) {
        List<Map<String, Object>> articleList = articleDaoImplement.listArticle();
        map.addAttribute("articleList", articleList);
        map.addAttribute("flag", "list");
        return "article_list";
    }

    @GetMapping("/detail/{id}")
    public String articleDetail(ModelMap map, @PathVariable Integer id) {
        T_Article t_Article = articleMapper.selectArticle(id);
        map.addAttribute("article", t_Article);
        map.addAttribute("flag", "detail");
        return "article_detail";
    }

    @GetMapping("/add")
    public String addArticle(ModelMap map) {
        map.addAttribute("flag", "add");
        return "article_add";
    }

    @PostMapping("/add")
    public String addArticleDone(ModelMap map, String author, String content, String type) {
        T_Article t_Article = T_Article.builder().author(author).content(content).type(type).build();
        int success = articleDaoImplement.addArticle(t_Article);
        map.addAttribute("success", success);
        map.addAttribute("flag", "add");
        return "article_add";
    }

    @GetMapping("/update/{id}")
    public String updateArticle(ModelMap map, @PathVariable Integer id) {
        T_Article t_Article = articleMapper.selectArticle(id);
        map.addAttribute("article", t_Article);
        map.addAttribute("flag", "update");
        return "article_update";
    }

    @PostMapping("/update/{id}")
    public String updateArticleDone(ModelMap map, @PathVariable Integer id, String content) {
        T_Article t_Article = T_Article.builder().id(id).content(content).build();
        int success = articleDaoImplement.updateArticle(t_Article);
        T_Article new_t_Article = articleMapper.selectArticle(id);
        map.addAttribute("article", new_t_Article);
        map.addAttribute("success", success);
        map.addAttribute("flag", "update");
        return "article_update";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(ModelMap map, @PathVariable Integer id) {
        T_Article t_Article = articleMapper.selectArticle(id);
        map.addAttribute("article", t_Article);
        map.addAttribute("flag", "delete");
        return "article_delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteArticleDone(ModelMap map, @PathVariable Integer id) {
        T_Article new_t_Article = articleMapper.selectArticle(id);
        int success = articleDaoImplement.deleteArticle(T_Article.builder().id(id).build());
        map.addAttribute("article", new_t_Article);
        map.addAttribute("success", success);
        map.addAttribute("flag", "delete");
        return "article_delete";
    }
}
