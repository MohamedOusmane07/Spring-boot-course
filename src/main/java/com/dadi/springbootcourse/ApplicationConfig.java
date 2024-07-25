package com.dadi.springbootcourse;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("My First Bean");
    }

    @Bean
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("My Second Bean");
    }

}
