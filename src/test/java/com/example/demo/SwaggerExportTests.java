package com.example.demo;

import io.github.swagger2markup.*;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-07 16:11
 * @LastEditTime: 2022-07-07 16:11
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)//固定端口 PORT:8888
public class SwaggerExportTests {
    @Test
    public void generateAsciiDocs() throws Exception {
        //輸出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)//設置生成格式
//                .withOutputLanguage(Language.ZH)//設置語言中文還是其他語言
//                .withPathsGroupedBy(GroupBy.TAGS)//根據@ApiOperation 中的tags 去導出
//                .withGeneratedExamples()
//                .withoutInlineSchema()
                .build();
        // Swagger2MarkupConverter 轉換器
        Path path = Paths.get("src/main/resources/docs/asciidoc");
        Swagger2MarkupConverter.from(new URL("http://localhost:8888/v2/api-docs"))//這個位置導出文黨
                .withConfig(config)
                .build()
                .toFile(path); //<--程式碼卡住 TODO 未處理
        //  .toFile(Paths.get("src/main/resources/docs/asciidoc"));//目錄下
    }

}
