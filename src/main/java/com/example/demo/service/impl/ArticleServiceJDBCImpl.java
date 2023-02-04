package com.example.demo.service.impl;

import com.example.demo.dao.ArticleJDBCDAO;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-07 13:48
 * @LastEditTime: 2022-07-07 13:48
 */
@Service
public class ArticleServiceJDBCImpl implements ArticleService {
    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Override
    public void saveArticle(Article article) {
        articleJDBCDAO.save(article);

    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        if(article.getId() == null){
            //TODO 拋出異常
        }

        articleJDBCDAO.updateById(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        System.out.println("ArticleServiceJDBCImpl getAll");
        return articleJDBCDAO.findAll();
    }
}
