package com.dadi.springbootcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
}) // Allow to read properties from another file
public class MyFirstService {


    private  MyFirstClass myFirstClass;
    @Value("${my.custom.properties}")
    private String customProperty;
    @Value("${my.custom.properties.name}")
    private String customProperty2;
    @Value("${my.custom.properties.int}")
    private Integer customPropertyInt;
    @Value("${my.custom.properties.int2}")
    private Integer customPropertyInt2;
    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("${my.prop.2}")
    private String customPropertyFromAnotherFile2;




    public MyFirstService(
            @Qualifier("mySecondBean")MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "the dependency is saying : "+ myFirstClass.sayHello();
    }


    public String getCustomProperty() {
        return customProperty;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    public Integer getCustomPropertyInt2() {
        return customPropertyInt2;
    }

    public String getCustomProperty2() {
        return customProperty2;
    }
}
