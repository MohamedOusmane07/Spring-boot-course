package com.dadi.springbootcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SpringbootCourseApplication {

    public static void main(String[] args) {

        var app= new SpringApplication(SpringbootCourseApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
        var ctx=app.run(args);

       MyFirstService myFirstService = ctx.getBean("myFirstService",MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
        System.out.println(myFirstService.getCustomProperty());
        System.out.println(myFirstService.getCustomProperty2());
        System.out.println(myFirstService.getCustomPropertyInt());
        System.out.println(myFirstService.getCustomPropertyInt2());
        //System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
        //System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());

    }


}
