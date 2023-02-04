package com.example.demo.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @program: demo
 * @description:監聽器的開發
 * @Creator: 阿昇
 * @CreateTime: 2022-07-15 12:30
 * @LastEditTime: 2022-07-15 12:30
 */
@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {//實現ApplicationListener的接口,接口的泛型運用鋼新增的事件MyEvent,當MyEvent事件被監聽到了將log打印出來
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        log.info(String.format("%s監聽到事件元: %s.", MyListener1.class.getName(),myEvent.getSource()));
    }
}
