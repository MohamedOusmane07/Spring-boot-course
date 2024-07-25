package com.dadi.springbootcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootCourseApplication {

    public static void main(String[] args) {

        var ctx=SpringApplication.run(SpringbootCourseApplication.class, args);

       MyFirstService myFirstService = ctx.getBean("myFirstService",MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
        System.out.println(myFirstService.getCustomProperty());
        System.out.println(myFirstService.getCustomPropertyInt());
        System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
        System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());

    }


}
