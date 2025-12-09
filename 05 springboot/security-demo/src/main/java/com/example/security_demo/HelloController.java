package com.example.security_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/")
  public String home() {
    return "Home works";
  }

  @GetMapping("/about")
  public String about() {
    return "About Works";
  }

  @GetMapping("/contact")
  public String contact() {
    return "Contact Works";
  }
}


