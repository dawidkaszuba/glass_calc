package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.BasePrice3Tile;
import pl.dawidkaszuba.glasscalc.repository.BasePrice3TileRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/basePrice3Tile")
public class BasePrice3TileController {

    @Autowired
    private BasePrice3TileRepository basePrice3TileRepository;


    @GetMapping("/show")
    public String showPrice(Model model){
        model.addAttribute("basePrice3",this.basePrice3TileRepository.findAll());
        return "cms/basePrice3Tile/show";
    }

    @GetMapping("/edit/{id}")
    public String editBasePriceForm(@PathVariable Long id, Model model){
        model.addAttribute("basePrice3", this.basePrice3TileRepository.findOne(id));
        return "cms/basePrice3Tile/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedBasePrice(@Valid BasePrice3Tile basePrice3Tile, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/basePrice3Tile/edit/"+basePrice3Tile.getId();
        }else{
            this.basePrice3TileRepository.save(basePrice3Tile);
            return "redirect:/basePrice3Tile/show";
        }
    }
}
