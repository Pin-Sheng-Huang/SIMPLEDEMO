package com.example.demo.controller;

import com.example.demo.exception.AjaxResponse;
import com.example.demo.model.Article;
import com.example.demo.model.ArticleVO;
import com.example.demo.service.ArticleService;
import com.example.demo.service.ExceptionService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-01 19:12
 * @LastEditTime: 2022-07-01 19:12
 */

@Slf4j
//@RestController  //實際上是@Controller + @ResponseBody的結合體
@Controller
@RequestMapping("/rest")
public class ArticleController {

    @Resource //controller調用資源
    ArticleService articleService;

    @Resource
    ExceptionService exceptionService;
    //查詢一篇文章,根據id
    //@RequestMapping(value="/articles/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/articles/{id}",produces = "application/json;charset=utf-8") //加了 produces 下載excel 會亂碼
    public @ResponseBody Article getArticle(HttpServletResponse response, @PathVariable("id") Long id) {
        if(id==1){
            exceptionService.systemBizError();
        }else {
            exceptionService.userBizError(-1);
        }

        Article article = articleService.getArticle(id);
        //        List<Reader>readers = new ArrayList<Reader>(){{
//                add(new Reader("Adonis",28));
//                add(new Reader("PIN",18));
//            }
//        };
//
//        Article article = Article.builder()
//                        .author("阿昇").content("java王者13").id(id).createTime(new Date()).reader(readers).title("handsomeguy").build();

        log.info("article:"+article);
        return article;
    }

    //新增一篇文章
    //@RequestMapping(value="/articles",method = RequestMethod.POST)
    //在POSTMAN 用json格式
//一種方式
    @PostMapping("/articles")
    //HTTP 傳參    ,@RequestHeader String aaaa
    public @ResponseBody AjaxResponse saveArticle( @RequestBody Article article){ //透過requestbody接收數據

        articleService.saveArticle(article);
        //因使用lombok 的Slf4j註解,這裡可以直接使用log變數打印日誌
        log.info("savearticle:"+article);
//        return AjaxResponse.success(article); //原本 ,ArticleRestControllerTEST、ArticleRestControllerTEST
//       return AjaxResponse.success(articleService.saveArticle(article));
        return AjaxResponse.success();
    }
//二種方式
    @ApiOperation(value = "添加文章",notes = "添加新的文章",tags = "Article",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "文章標題",required = true,dataType = "String"),
            @ApiImplicitParam(name = "content",value = "文章內容",required = true,dataType = "String"),
            @ApiImplicitParam(name = "author",value = "文章作者",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class)
    })
    @PostMapping("/articles2")
    public AjaxResponse saveArticle(@RequestParam String author,
                                    @RequestParam String title,
                                    @RequestParam String content,
                                    @DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss")
                                    @RequestParam Date createTime){


        log.info("savearticle:"+createTime);

        return AjaxResponse.success();
    }

    //修改一篇文章
    //@RequestMapping(value="/articles",method = RequestMethod.PUT)
    @PutMapping("/articles")
    public @ResponseBody AjaxResponse updateArticle(@RequestBody Article article){
        if(article.getId() == null){
            //TODO 拋出異常錯誤
            System.out.println("沒有id");
        }
        articleService.updateArticle(article);
        log.info("updateArticle:"+article);
        return AjaxResponse.success();
    }

    //刪除一篇文章,根據id
    //@RequestMapping(value="/articles/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable("id") Long id){

        articleService.deleteArticle(id);
        log.info("deleteArticle:"+id);
        return AjaxResponse.success();
    }

    //查詢文章
    @GetMapping("/articles")
    public @ResponseBody AjaxResponse getArticle() {
        List<Article> articles = articleService.getAll();

       log.info("article"+ articles);
        System.out.println(articles);
        return AjaxResponse.success(articles);
    }
}
