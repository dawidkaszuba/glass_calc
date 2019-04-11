package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.Foil;
import pl.dawidkaszuba.glasscalc.repository.FoilRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/foil")
public class FoilController {

    @Autowired
    private FoilRepository foilRepository;

    @GetMapping("/add")
    public String addFoilForm(Model model){
        model.addAttribute("foil", new Foil());
        return "cms/foil/add";
    }

    @PostMapping("/add")
    public String addFoil(@Valid Foil foil, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cms/foil/add";
        }else{
            this.foilRepository.save(foil);
            return "redirect:/foil/list";
        }
    }

    @GetMapping("edit/{id}")
    public String editFoilForm(@PathVariable Long id, Model model){
        model.addAttribute("foil", this.foilRepository.findOne(id));
        return "cms/foil/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEdited(@Valid Foil foil, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/foil/edit/"+foil.getId();
        }else{
            this.foilRepository.save(foil);
            return "redirect:/foil/list";
        }
    }

    @GetMapping("/list")
    public String findAllFoils(Model model){
        model.addAttribute("foils", this.foilRepository.findAll());
        return "cms/foil/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteFoil(@PathVariable Long id){
        this.foilRepository.delete(id);
        return "redirect:/foil/list";
    }
}
