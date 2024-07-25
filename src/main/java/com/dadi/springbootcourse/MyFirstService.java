package com.dadi.springbootcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private  MyFirstClass myFirstClass;
    private Environment environment;


    @Autowired
    public void setMyFirstClass(@Qualifier("mySecondBean") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }


    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }
    public String getOsName(){
        return environment.getProperty("os.name");
    }
    public String getProp(){
        return environment.getProperty("spring.application.name");
    }









    public String tellAStory(){
        return "the dependency is saying : "+ myFirstClass.sayHello();
    }


}
