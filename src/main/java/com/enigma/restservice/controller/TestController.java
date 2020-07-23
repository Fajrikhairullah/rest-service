package com.enigma.restservice.controller;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping(path = "", produces = "text/html")
//    @ResponseBody
    public String testGet(@RequestParam("name") String[] names,
            HttpServletRequest request, HttpServletResponse response) {
        Enumeration<String> e = request.getHeaderNames();
        String result = "";
        while (e.hasMoreElements()) {

            String header = e.nextElement();
            String value = request.getHeader(header);
            result += header + ": " + value + "<br>";
        }
        result += "<br>";

        for (String name : names) {
            result += "[GET] <b>Hello, </b>" + name + "<br>";
        }
        return result;

    }

    @PostMapping(produces = "text/html")
    public String testPost(@RequestParam String name, @RequestParam int age) {
        return "[POST] <b>Hello, </b>" + name + ", your age is : " + age;
    }

}
