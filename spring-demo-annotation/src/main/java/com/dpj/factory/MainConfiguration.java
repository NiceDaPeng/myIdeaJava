package com.dpj.factory;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages={"com.dpj.dao","com.dpj.service","com.dpj.factory"})
@Import(MyFactoryBean.class)
public class MainConfiguration {


}
