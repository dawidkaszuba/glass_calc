package pl.dawidkaszuba.glasscalc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
   // @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String home(){
        return "home/home";
    }
}
