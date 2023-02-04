package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import java.io.Reader;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-04 13:12
 * @LastEditTime: 2022-07-04 13:12
 */

//@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonPropertyOrder(value = {"content","author"})
public class Article {
//    @JsonIgnore
    private  Integer id;
   // @JsonProperty("autheer") //通常放在類中屬性的成員變數上方
    private String author;
    private String title;
//    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8") //日期格式化
    @NotEmpty(message = "文章內容不能為空")
    private String content;
    private Date createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Reader>reader; //有多個職 ,只能使用Requestbody
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(String createTime) {
//        this.createTime = createTime;
//    }
    //    private List<ReaderBean> reader;


}
