package org.launchcode.hello_spring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping //Get request calls method welcomePage then returns with @ResponceBody//
    @ResponseBody
    public String welcomePage() {
        return "Welcome to LaunchCode!";
    }

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String returnGoodbye() {
        return "Thank you for visiting LaunchCode!";
    }

// Video two, creating Query Parameters for Dynamic Web Form//
    // http://localhost:8080/hello?name=Zack //

    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        if (name.equals("zack")) {
            return "Hello " + name + "!";
        } else {
            return name + "Please Leave!";
        }
    }

    // Handles Request of the form /hello/launchCode http://localhost:8080/hello/zack//
    @GetMapping("hello/{name}")
    @ResponseBody
    public String queryWithPathParameter(@PathVariable String name) {
        if (name.equals("zack")) {
            return "Hello " + name + "!";
        } else {
            return returnGoodbye();

        }
    }
}