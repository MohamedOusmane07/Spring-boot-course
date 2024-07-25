package com.dadi.springbootcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootCourseApplication {

    public static void main(String[] args) {

        var ctx=SpringApplication.run(SpringbootCourseApplication.class, args);
       // myFirstClass = ctx.getBean("myFirstBean",MyFirstClass.class);
       //System.out.println(myFirstClass.sayHello());

       MyFirstService myFirstService = ctx.getBean("myFirstService",MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
        System.out.println(myFirstService.getJavaVersion());
        System.out.println(myFirstService.getOsName());
        System.out.println(myFirstService.getProp());

    }


}
