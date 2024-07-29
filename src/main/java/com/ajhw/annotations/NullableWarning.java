package com.ajhw.annotations;

import java.lang.annotation.*;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NullableWarning {

}

