package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.StandardPrice3TilesGlass;
import pl.dawidkaszuba.glasscalc.repository.StandardPrice3TilesGlassRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/standardPrice3")
public class StandardPrice3TilesGlassController {

    private final StandardPrice3TilesGlassRepository standardPrice3TilesGlassRepository;

    @Autowired
    public StandardPrice3TilesGlassController(StandardPrice3TilesGlassRepository standardPrice3TilesGlassRepository) {
        this.standardPrice3TilesGlassRepository = standardPrice3TilesGlassRepository;
    }

    @GetMapping("/show")
    public String showPrice(Model model){
        model.addAttribute("price", standardPrice3TilesGlassRepository.findAll());
        return "cms/standardPrice3Tiles/show";
    }

    @GetMapping("/edit/{id}")
    public String editPriceForm(@PathVariable Long id, Model model){
        model.addAttribute("price", this.standardPrice3TilesGlassRepository.findOne(id));
        return "cms/standardPrice3Tiles/edit";
    }

    @PostMapping("/saveEdited")
    public  String saveEditedPrice(@Valid StandardPrice3TilesGlass standardPrice3TilesGlass, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/standardPrice3/edit/"+ standardPrice3TilesGlass.getId();
        }else{
            this.standardPrice3TilesGlassRepository.save(standardPrice3TilesGlass);
            return "redirect:/standardPrice3/show";
        }
    }
}
