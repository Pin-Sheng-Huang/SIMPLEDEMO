package com.example.demo;

import com.example.demo.model.Article;
import com.example.demo.model.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-06 15:24
 * @LastEditTime: 2022-07-06 15:24
 */

public class JacksonTest {
    @Test
    void testJackson() throws JsonProcessingException {
        //jackson的ObjectMapper轉換對象
        ObjectMapper mapper = new ObjectMapper(); //實現JAVA對象和jackson字符串的相互轉換

        List<Reader> readers = new ArrayList<Reader>(){{
            add(new Reader("Adonis",28));
            add(new Reader("PIN",18));
        }
        };

        Article article = Article.builder()
                .author("阿昇").content("java王者13").id(2).createTime(new Date()).reader(readers).title("handsomeguy").build();
       String jsonStr =  mapper.writeValueAsString(article);//把ARTICLE 轉換成JSON字符串,轉換前的對象需要加上 @AllArgsConstructor @NoArgsConstructor
        System.out.println("article對象轉換成json字串:"+jsonStr);

        Article article1= mapper.readValue("{\"content\":\"java王者13\",\"autheer\":\"阿昇\",\"title\":\"handsomeguy\",\"createTime\":1657092692911,\"reader\":[{\"name\":\"Adonis\",\"age\":28},{\"name\":\"PIN\",\"age\":18}]}",
                Article.class);//readvalue讀值 ,轉換前的對象需要加上 @AllArgsConstructor @NoArgsConstructor
        System.out.println("將Json字串轉換成對象:"+article1);
    }

}
