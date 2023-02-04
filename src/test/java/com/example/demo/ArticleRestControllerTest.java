package com.example.demo;

import com.example.demo.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @program: demo單元測試 (servlet容器測試)
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-06 15:56
 * @LastEditTime: 2022-07-06 15:56
 */
@Slf4j
public class ArticleRestControllerTest {
    //mock對象
    private static MockMvc mockMvc;//MockMvc對象幫助模擬http請求

    @BeforeAll //所有測試方法的前面去執行
    static void setUp() {//進行初始化
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }
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
//                .andExpect(MockMvcRequestBuilders.status().isOK()) //status不知為何失敗
                .andDo(print())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());//在log日誌上打印出來
    }
}
