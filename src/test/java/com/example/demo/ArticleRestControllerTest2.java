package com.example.demo;

import com.example.demo.controller.ArticleController;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/** 字母哥 243集
 * @program: demo單元測試
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-06 15:56
 * @LastEditTime: 2022-07-06 15:56
 */
@Slf4j
//當代碼出現@Resource和 @Autowired 來實現Bean依賴注入時TEST要加上下方3個註解
@AutoConfigureMockMvc//自動構建mockmvc 對象
//@SpringBootTest //用來加載Spring上下文,嘗試把所有項目的Bean注入近來
@WebMvcTest(ArticleController.class)//輕量級加載當前的測試 只需要加載這個(ArticleController.class)Bean
@ExtendWith(SpringExtension.class)//需要為我們當前的spring容器用依賴注入
//構建上下文環境和 SERVLET容器環境
public class ArticleRestControllerTest2 {
    //mock對象
    @Resource
    private MockMvc mockMvc;
    @MockBean //假的Bean
    private ArticleService articleService;
// ArticleRestController1 @BeforeAll注解
//    @BeforeAll //所有測試方法的前面去執行
//    static void setUp() {//進行初始化
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }
    @Test
    public void saveArticle() throws Exception {

        String article = "{\"content\":\"java王者13\"" +
                ",\"autheer\":\"阿昇\",\"title\":\"handsomeguy\"" +
                ",\"createTime\":1657093113618,\"reader\":[{\"name\":\"Adonis\"" +
                ",\"age\":28},{\"name\":\"PIN\",\"age\":18}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        Article articleObj = objectMapper.readValue(article,Article.class);

       // when(articleService.saveArticle(articleObj)).thenReturn("ok");

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles") //在這邊請求使用HTTP協議的POST方法
                        .contentType("application/json")//使用Json數據
                        .content(article)
        )
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok")) //不成功
                .andDo(print())
                .andReturn()
                ;
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());//在log日誌上打印出來
    }
}
