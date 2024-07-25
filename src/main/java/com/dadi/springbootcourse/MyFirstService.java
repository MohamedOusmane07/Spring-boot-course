package com.dadi.springbootcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    //private final MyFirstClass myFirstClass2;
    private  MyFirstClass myFirstClass;

    @Autowired
    public void injectDependencies(@Qualifier("myFirstBean") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory(){
        return "the dependency is saying : "+ myFirstClass.sayHello();
    }
}
