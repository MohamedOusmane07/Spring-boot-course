package com.dadi.springbootcourse;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    //@Qualifier("first")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("My First Bean");
    }

    @Bean
    //@Qualifier("second")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("My Second Bean");
    }

}
