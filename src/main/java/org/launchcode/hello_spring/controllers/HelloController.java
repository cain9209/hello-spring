package org.launchcode.hello_spring.controllers;

import org.springframework.ui.Model;
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


    // retreive the themplate/form with a getmethod//
    @GetMapping("form")
    public String getForm() {
        return "form"; // return name of the static template //
    }

    // map the request of the parameter to /hello and then add the attribute name to the view  and return form//
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello " + name + " how are you today?";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // same controller as early but at /name//
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello " + name + "!");
        return "hello";
    }


}
