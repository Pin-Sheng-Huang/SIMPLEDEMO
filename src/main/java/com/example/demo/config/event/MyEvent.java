package com.example.demo.config.event;

import org.springframework.context.ApplicationEvent;

/**
 * @program: demo
 * @description:新增事件 繼承ApplicationEvent
 * @Creator: 阿昇
 * @CreateTime: 2022-07-15 12:26
 * @LastEditTime: 2022-07-15 12:26
 */

public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {//通過事件構造函數去傳遞事件元的訊息
        super(source);
    }
}
