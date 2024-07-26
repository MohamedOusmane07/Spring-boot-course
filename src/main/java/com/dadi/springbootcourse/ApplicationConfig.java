package com.dadi.springbootcourse;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {

    @Bean
    //@Profile("dev")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("My First Bean");
    }

    @Bean
    //@Profile("test")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("My Second Bean");
    }

}
