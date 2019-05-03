package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CMSController {
    @GetMapping("/cms")
    public String homeCMS(){
        return "cms/cms";
    }

}
