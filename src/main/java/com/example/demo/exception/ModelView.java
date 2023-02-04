package com.example.demo.exception;

import java.lang.annotation.*;

@Documented//註解類必備
@Retention(RetentionPolicy.RUNTIME)//註解類必備
@Target({ElementType.METHOD})//只能在方法上使用此註解 ,表示當前的ModelView是標住在ElementType.METHOD上面的,純屬標註類
public @interface ModelView {
}
