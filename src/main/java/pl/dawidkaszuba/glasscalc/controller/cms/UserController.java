package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.Role;
import pl.dawidkaszuba.glasscalc.entity.User;
import pl.dawidkaszuba.glasscalc.repository.RoleRepository;
import pl.dawidkaszuba.glasscalc.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
            user.setPassword(passwordEncoder.encode(user.getPassword()));
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
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepository.save(user);
            return "redirect:/user/list";
        }
    }


    @ModelAttribute("roles")
    public List<Role> findAllRoles(){
        return this.roleRepository.findAll();
    }



    @PostConstruct
    public void addFirstUsers(){

        Set<Role> rolesAdmin = new HashSet<>();
        rolesAdmin.add(this.roleRepository.findOne(1L));
        User admin = new User("glasscalc24@gmail.com",
                passwordEncoder.encode("admin"),"Dawid","Kaszuba",1,rolesAdmin);
        userRepository.save(admin);

        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(this.roleRepository.findOne(2L));

        User user = new User("d.kaszuba89@gmail.com",
                passwordEncoder.encode("user"),"Dawid","Kaszuba",1,rolesUser);
        userRepository.save(user);
    }


}
