package com.dadi.springbootcourse;


import org.springframework.web.bind.annotation.*;

@RestController
public class MyFisrtController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Mohamed from your First Controller";
    }


    @PostMapping("/post")
    public String message(
            @RequestBody OrderRecord order){
        return order.toString();
    }


    @GetMapping("/hello-2/{n}")
    public String hello2(
            @PathVariable("n") String name
    ){
      return "Hello "+name +" from your First Controller";

    }

    @GetMapping("/Hello-2/params")
    public String hello2Params(
            @RequestParam String name,
            @RequestParam int age
    ){
        return name +" vous avez "+age;
    }
}



