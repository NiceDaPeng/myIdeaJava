package com.dpj.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter<String, Date> {

    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * 自定义日期类型转换器
     * 1，实现Converter接口，重写conert方法
     *
     * @param resource 原数据的
     * @return 转换以后的数据以及类型
     */
    @Override
    public Date convert(String resource) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(resource);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
