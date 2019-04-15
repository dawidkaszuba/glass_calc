package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.StandardPrice2TilesGlass;
import pl.dawidkaszuba.glasscalc.repository.StandardPrice2TilesGlassRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/standardPrice2")
public class StandardPrice2TilesGlassController {

    @Autowired
    private StandardPrice2TilesGlassRepository standardPrice2TilesGlassRepository;

    @GetMapping("/show")
    public String showPrice(Model model){
        model.addAttribute("price", standardPrice2TilesGlassRepository.findAll());
        return "cms/standardPrice2Tiles/show";
    }

    @GetMapping("/edit/{id}")
    public String editPriceForm(@PathVariable Long id, Model model){
        model.addAttribute("price", this.standardPrice2TilesGlassRepository.findOne(id));
        return "cms/standardPrice2Tiles/edit";
    }

    @PostMapping("/saveEdited")
    public  String saveEditedPrice(@Valid StandardPrice2TilesGlass standardPrice2TilesGlass, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/standardPrice2/edit/"+ standardPrice2TilesGlass.getId();
        }else{
            this.standardPrice2TilesGlassRepository.save(standardPrice2TilesGlass);
            return "redirect:/standardPrice2/show";
        }
    }

}
