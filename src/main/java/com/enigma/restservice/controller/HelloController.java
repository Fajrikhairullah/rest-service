package com.enigma.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {
   
   @Autowired
   private MessageSource messageSource;
   
   @GetMapping
   public String sayHello(){
       String message = messageSource.getMessage("hello", new String[]{"fajri"}, LocaleContextHolder.getLocale());
       return message;
       
   }
}
