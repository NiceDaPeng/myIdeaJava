package myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target()表示的是元注解，表示的是自定义注解可以放在什么位置
//ElementType是一个枚举类型
//里面的对象有：FIELD,METHOD,CONSTRUCTOR,PARAMTER,PACKAGE,ANNOTATION_TYPE,TYPE_USE
@Target({ElementType.FIELD, ElementType.METHOD,ElementType.CONSTRUCTOR})
//@Retention表示的是自定义注解的声明周期，取值为：RetentionPolicy.SOURCE--Retention.CLASS--Retention.RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

}
