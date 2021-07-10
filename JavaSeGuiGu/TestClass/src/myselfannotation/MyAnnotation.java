package myselfannotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD,METHOD,CONSTRUCTOR,TYPE})
@Retention(RUNTIME)
@Inherited//子类可以继承此注解
public @interface MyAnnotation {

    String[] value();//我们定义了一个方法在注解中，如果我们在使用的时候没有传递参数
    //那么就会把default后面的数据当作返回值搬运走。
}
