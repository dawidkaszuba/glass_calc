package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.User;
import pl.dawidkaszuba.glasscalc.mail.Mail;
import pl.dawidkaszuba.glasscalc.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {

    private final UserRepository userRepository;

    @Autowired
    public MailController(UserRepository userRepository) {

        this.userRepository=userRepository;
    }

    @GetMapping("/compose")
    public String composeMail(Model model){
        model.addAttribute("mail", new Mail());
        return "cms/mail/compose";
    }

    @PostMapping("/send")
    public String sendMail(@Valid Mail mail, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "cms/mail/compose";
        }else{
            mail.send("glasscalc24@gmail.com", "glassCalc123", mail.getMailTo(), mail.getSubject(),
                    mail.getMessage());
        }

        return "cms/mail/success";
    }

    @ModelAttribute("recipients")
    public List<User> findAll(){
        return this.userRepository.findAll();
    }
}
