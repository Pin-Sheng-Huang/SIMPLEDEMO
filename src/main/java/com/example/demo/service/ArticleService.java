package com.example.demo.service;

import com.example.demo.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-06 17:10
 * @LastEditTime: 2022-07-06 17:10
 */
// 字母哥242集,才可測試ArticleRestControllerTest,1
//@Service
//public class ArticleService {
//}

//為了MOCK測試
    @Service
public interface ArticleService { //測試ArticleRestControllerTest1//模擬這接口未實現
    public void saveArticle(Article article);//方法  //原本是String
    void deleteArticle(Long id);
    void updateArticle(Article article);
    Article getArticle(Long id);
    List<Article> getAll();
}
