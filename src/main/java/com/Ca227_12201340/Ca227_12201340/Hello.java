package com.Ca227_12201340.Ca227_12201340;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/")
    public  String hel(){
        return "hello";
    }
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        return "Hello" + name;
    }
}
