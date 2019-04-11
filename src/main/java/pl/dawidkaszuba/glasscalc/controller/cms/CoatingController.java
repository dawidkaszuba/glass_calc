package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.Coating;
import pl.dawidkaszuba.glasscalc.repository.CoatingRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/coating")
public class CoatingController {


    @Autowired
    private CoatingRepository coatingRepository;

    @GetMapping("/add")
    public String addCoatingForm(Model model){
        model.addAttribute("coating", new Coating());
        return "cms/coating/add";
    }

    @PostMapping("/add")
    public String addCoating(@Valid Coating coating, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cms/coating/add";
        }else{
            this.coatingRepository.save(coating);
            return "redirect: /coating/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCoatingForm(@PathVariable Long id, Model model){
        model.addAttribute("coating", this.coatingRepository.findOne(id));
        return "cms/coating/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedCoating(@Valid Coating coating, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/coating/edit/"+coating.getId();
        }else{
            this.coatingRepository.save(coating);
            return "redirect:/coating/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCoatings(@PathVariable Long id){
        this.coatingRepository.delete(id);
        return "redirect:/coating/list";
    }

    @GetMapping("/list")
    public String findAllCoatings(Model model){
        model.addAttribute("coatings", this.coatingRepository.findAll());
        return "cms/coating/list";
    }
}
