package com.example.demo;

import com.example.demo.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @program: demo單元測試
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-06 15:56
 * @LastEditTime: 2022-07-06 15:56
 */
@Slf4j
//當代碼出現@Resource和 @Autowired 來實現Bean依賴注入時TEST要加上下方3個註解
@SpringBootTest
@AutoConfigureMockMvc//自動構建mockmvc 對象 ,(要@Service財旭曜的註解)
@ExtendWith(SpringExtension.class)//需要為我們當前的spring容器用依賴注入,(要@Service財旭曜的註解)
//構建上下文環境和 SERVLET容器環境
public class ArticleRestControllerTest1 {
    //mock對象
    @Resource
    private  MockMvc mockMvc;//static 去除
// ArticleRestController1 @BeforeAll注解

    @Test
    public void saveArticle() throws Exception {

        String article = "{\"content\":\"java王者13\"" +
                ",\"autheer\":\"阿昇\",\"title\":\"handsomeguy\"" +
                ",\"createTime\":1657093113618,\"reader\":[{\"name\":\"Adonis\"" +
                ",\"age\":28},{\"name\":\"PIN\",\"age\":18}]}";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles") //在這邊請求使用HTTP協議的POST方法
                        .contentType("application/json")//使用Json數據
                        .content(article)
        )
                .andExpect(MockMvcResultMatchers.status().isOk()) //status不知為何失敗
                .andDo(print())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());//在log日誌上打印出來
    }
}
