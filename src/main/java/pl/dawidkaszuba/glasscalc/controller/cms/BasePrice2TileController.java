package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.BasePrice2Tile;
import pl.dawidkaszuba.glasscalc.repository.BasePrice2TileRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/basePrice2Tile")
public class BasePrice2TileController {

    @Autowired
    private BasePrice2TileRepository basePrice2TileRepository;


    @GetMapping("/show")
    public String showPrice(Model model){
        model.addAttribute("basePrice2",this.basePrice2TileRepository.findAll());
        return "cms/basePrice2Tile/show";
    }

    @GetMapping("/edit/{id}")
    public String editBasePriceForm(@PathVariable Long id, Model model){
        model.addAttribute("basePrice2", this.basePrice2TileRepository.findOne(id));
        return "cms/basePrice2Tile/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedBasePrice(@Valid BasePrice2Tile basePrice2Tile, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/basePrice2Tile/edit/"+basePrice2Tile.getId();
        }else{
            this.basePrice2TileRepository.save(basePrice2Tile);
            return "redirect:/basePrice2Tile/show";
        }
    }
}
