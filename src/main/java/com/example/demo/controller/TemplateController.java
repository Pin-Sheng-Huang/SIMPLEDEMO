package com.example.demo.controller;

import com.example.demo.exception.CustomException;
import com.example.demo.exception.CustomExceptionType;
import com.example.demo.exception.ModelView;
import com.example.demo.model.Article;
import com.example.demo.model.ArticleVO;
import com.example.demo.service.ArticleService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-18 19:12
 * @LastEditTime: 2022-07-18 19:12
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource
    ArticleService articleService;

    @ModelView
    @GetMapping("/freemarker")
    public String index(Model model){
        if(1 == 1){
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
        }

        List<Article>articles = articleService.getAll();

        model.addAttribute("articles", articles);

        return "freemarkertemp";
    }
}
