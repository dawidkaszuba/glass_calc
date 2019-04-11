package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.Coating;
import pl.dawidkaszuba.glasscalc.entity.TileGroup;
import pl.dawidkaszuba.glasscalc.entity.Tile;
import pl.dawidkaszuba.glasscalc.repository.CoatingRepository;
import pl.dawidkaszuba.glasscalc.repository.TileGroupRepository;
import pl.dawidkaszuba.glasscalc.repository.TileRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tile")
public class TileController {

    @Autowired
    private TileGroupRepository tileGroupRepository;

    @Autowired
    private TileRepository tileRepository;

    @Autowired
    private CoatingRepository coatingRepository;

    @GetMapping("/add")
    public String addTailForm(Model model){
        model.addAttribute("tile", new Tile());
        return "cms/tile/add";
    }

    @PostMapping("/add")
    public String addTile(@Valid Tile tile, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cms/tile/add";
        }else{
            this.tileRepository.save(tile);
            return "redirect:/tile/list";
        }
    }

    @GetMapping("/list")
    public String findAllTiles(Model model){
        model.addAttribute("tiles",this.tileRepository.findAll());
        return "cms/tile/list";
    }

    @GetMapping("/edit/{id}")
    public String editTileForm(@PathVariable Long id, Model model){
       model.addAttribute("tile", this.tileRepository.findOne(id));
       return "cms/tile/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedTile(@Valid Tile tile, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/tile/edit/"+tile.getId();
        }else{
            this.tileRepository.save(tile);
            return "redirect:/tile/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTile(@PathVariable Long id){
        this.tileRepository.delete(id);
        return "redirect:/tile/list";
    }


    @ModelAttribute("tileGroups")
    public List<TileGroup> findAllTileGroups(){
        return this.tileGroupRepository.findAll();
    }

    @ModelAttribute("coatings")
    public List<Coating> findAllCoatings(){
        return this.coatingRepository.findAll();
    }
}
