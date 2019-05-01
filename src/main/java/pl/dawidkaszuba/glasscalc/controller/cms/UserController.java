package pl.dawidkaszuba.glasscalc.controller.cms;

import antlr.ASTNULLType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.Role;
import pl.dawidkaszuba.glasscalc.entity.User;
import pl.dawidkaszuba.glasscalc.repository.RoleRepository;
import pl.dawidkaszuba.glasscalc.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/add")
    public String addUserForm(Model model){
        model.addAttribute("user", new User());
        return "cms/user/add";
    }

    @PostMapping("/add")
    public String saveUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/user/add";
        }else{
            this.userRepository.save(user);
            return "redirect:/user/list";
        }
    }

    @GetMapping("/list")
    public String findAllUsers(Model model){
        model.addAttribute("users",this.userRepository.findAll());
        return "cms/user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        this.userRepository.delete(id);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(Model model, @PathVariable Long id){
        model.addAttribute("user", this.userRepository.findOne(id));
        return "cms/user/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/user/edit/"+user.getId();
        }else{
            this.userRepository.save(user);
            return "redirect:/user/list";
        }
    }

    @ModelAttribute("roles")
    public List<Role> findAllRoles(){
        return this.roleRepository.findAll();
    }
}
