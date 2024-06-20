package org.launchcode.hello_spring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    @ResponseBody//Get request calls method welcomePage then returns with @ResponceBody//
    public String welcomePage() {
        return "Welcome to LaunchCode!";
    }

    // handles request that are not "Zack" //
    @GetMapping("goodbye")
    @ResponseBody
    public String returnGoodbye() {
        return "Thank you for visiting LaunchCode please leave!";
    }

    // We have to create a form this way until templates are introduced later on//
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value="hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello " + name + " Welcome to learning Get and Post request!";


    }

    // Form get info from /hello and then post the info back to /hello hence the @RequestMapping//
    @GetMapping("form")
    public String getForm() {
        return "form"; // return name of the static template //
    }
}
