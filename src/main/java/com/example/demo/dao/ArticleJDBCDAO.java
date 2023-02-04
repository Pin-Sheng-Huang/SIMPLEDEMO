package com.example.demo.dao;

import com.example.demo.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-11 13:50
 * @LastEditTime: 2022-07-11 13:50
 */
@Repository //持久層依賴注入的對象
public class ArticleJDBCDAO {

    @Resource
    // @Autowired(required=true)
    private  JdbcTemplate jdbcTemplate;


    //保存文章
    public void save(Article article){

        jdbcTemplate.update("INSERT INTO article(author, title,content,create_time) values(?, ?, ?, ?)",
                    article.getAuthor(),
                    article.getTitle(),
                    article.getContent(),
                    article.getCreateTime());

    }

    //刪除文章
    public void deleteById(Long id){
        jdbcTemplate.update("DELETE  FROM article WHERE id= ?",id);
    }
    //更新文章
    public void updateById(Article article){


        jdbcTemplate.update("UPDATE article SET author = ?,title= ?,content= ?,create_time =? WHERE id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
        System.out.println(article.getId());
    }


    public Article findById(Long id){
       return jdbcTemplate.queryForObject(("SELECT * FROM article WHERE id=?"),new Object[]{id},
               new BeanPropertyRowMapper<>(Article.class));
///("SELECT * FROM article WHERE id=?",new Object[]{id},
//                new BeanPropertyRowMapper<>(Article.class))
    }

    public List<Article> findAll(){
        List<Article> rows = jdbcTemplate.query("SELECT * FROM article", new BeanPropertyRowMapper<>(Article.class));
        System.out.println("findAll");
        System.out.println(rows);
        return rows;
    }
}
