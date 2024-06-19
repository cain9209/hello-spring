package org.launchcode.hello_spring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
public class HelloController {

    @GetMapping //Get request calls method welcomePage then returns with @ResponceBody//
    public String welcomePage() {
        return "Welcome to LaunchCode!";
    }
// handles request that are not "Zack" //
    @GetMapping("goodbye")
    public String returnGoodbye() {
        return "Thank you for visiting LaunchCode please leave!";
    }

// We have to create a form this way until templates are introduced later on//
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
public String helloWithQueryParam(@RequestParam String name) {
    if (name.equals("Zack")) {
        return "Hello " + name + " Welcome to learning Get and Post request!";
    } else {
        return returnGoodbye();
    }

}

// Form get info from /hello and then post the info back to /hello hence the @RequestMapping//
@GetMapping("form")
@ResponseBody
public String helloForm() {
    return "<html>" +
            "<body>" +
            "<form action='hello' method='Post'>" +
            "<input type='text' name='name'>" +
            "<input type='submit' value='Greet Me'>" +
            "</form>" +
            "</body>" +
            "</html>";
}
}