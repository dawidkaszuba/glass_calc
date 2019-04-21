package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.Addition;
import pl.dawidkaszuba.glasscalc.repository.AdditionRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/addition")
public class AdditionController {

    @Autowired
    private AdditionRepository additionRepository;

    @GetMapping("/add")
    public String addAdditionForm(Model model){
        model.addAttribute("addition", new Addition());
        return "cms/addition/add";
    }

    @PostMapping("/add")
    public String saveAddition(@Valid Addition addition, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/addition/add";
        }else{
            this.additionRepository.save(addition);
            return "redirect:/addition/list";
        }
    }

    @GetMapping("/list")
    public String getAllAdditions(Model model){
        model.addAttribute("additions",this.additionRepository.findAll());
        return "cms/addition/list";
    }

    @GetMapping("delete/{id}")
    public String deleteAddition(@PathVariable Long id) {
        this.additionRepository.delete(id);
        return "redirect:/addition/list";
    }

    @GetMapping("edit/{id}")
    public String editAdditionForm(@PathVariable Long id, Model model){
        model.addAttribute("addition", this.additionRepository.findOne(id));
        return "cms/addition/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedAddition(@Valid Addition addition, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/addition/edit/"+ addition.getId();
        }else{
            this.additionRepository.save(addition);
            return "redirect:/addition/list";
        }
    }


}
