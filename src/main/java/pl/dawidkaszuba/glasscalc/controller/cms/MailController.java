package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.User;
import pl.dawidkaszuba.glasscalc.mail.Mail;
import pl.dawidkaszuba.glasscalc.repository.UserRepository;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/mail")
public class MailController {


    private final Mail mail;
    private final UserRepository userRepository;

    @Autowired
    public MailController(Mail mail, UserRepository userRepository) {
        this.mail = mail;
        this.userRepository=userRepository;
    }

    @GetMapping("/compose")
    public String composeMail(){
        return "cms/mail/compose";
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam List<String> mailTo, @RequestParam String sub, @RequestParam String message) {
        this.mail.send("glasscalc24@gmail.com","glassCalc123",mailTo, sub, message);
        return "cms/mail/success";
    }

    @ModelAttribute("recipients")
    public List<User> findAll(){
        return this.userRepository.findAll();
    }
}
