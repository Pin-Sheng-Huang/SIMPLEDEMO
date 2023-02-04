package example.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description:
 * @Creator: 昇
 * @CreateTime: 2022-07-01 16:54
 * @LastEditTime: 2022-07-01 16:54
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "hi";
    }
}
