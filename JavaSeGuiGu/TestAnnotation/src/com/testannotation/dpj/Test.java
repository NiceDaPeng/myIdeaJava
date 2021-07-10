package com.testannotation.dpj;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        try {
            test();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @TestAnnotation(arr = {"ahah", "java"}, Value = 1234)
    public static void test() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("com.testannotation.dpj.Test");
        Method test = clazz.getMethod("test");
        AnnotatedType annotatedReturnType = test.getAnnotatedReturnType();
        System.out.println(annotatedReturnType);
    }
}
