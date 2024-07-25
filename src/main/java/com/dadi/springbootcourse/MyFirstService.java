package com.dadi.springbootcourse;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass2;
    private final MyFirstClass myFirstClass;

    public MyFirstService(@Qualifier("myFirstBean") MyFirstClass myFirstClass,@Qualifier("mySecondBean") MyFirstClass myFirstClass2) {
        this.myFirstClass = myFirstClass;
        this.myFirstClass2= myFirstClass2;
    }


    public String tellAStory(){
        return "the dependency is saying : "+ myFirstClass.sayHello() + "\n" +
         "the dependency is saying : "+ myFirstClass2.sayHello();
    }
}
