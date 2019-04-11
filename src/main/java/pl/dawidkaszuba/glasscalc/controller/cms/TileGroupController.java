package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.TileGroup;
import pl.dawidkaszuba.glasscalc.repository.TileGroupRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/tileGroup")
public class TileGroupController {

    @Autowired
    private TileGroupRepository tileGroupRepository;

    @GetMapping("/add")
    public String addTileGroupForm(Model model){
        model.addAttribute("tileGroup", new TileGroup());
        return "cms/tileGroup/add";
    }
    @PostMapping("/add")
    public String addTileGroup(@Valid TileGroup tileGroup, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cms/tileGroup/add";
        }else{
            this.tileGroupRepository.save(tileGroup);
            return "redirect:/tileGroup/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editTileGroupForm(@PathVariable Long id, Model model){
        model.addAttribute("tileGroup", this.tileGroupRepository.findOne(id));
        return "cms/tileGroup/edit";
    }
    @PostMapping("/saveEdited")
    public String saveEditedTileGroup(@Valid TileGroup tileGroup, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/tileGroup/edit/"+tileGroup.getId();
        }else{
            this.tileGroupRepository.save(tileGroup);
            return "redirect:/tileGroup/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTileGroup(@PathVariable Long id){
        this.tileGroupRepository.delete(id);
        return "redirect:/tileGroup/list";
    }

    @GetMapping("/list")
    public String findAllTileGroup(Model model){
        model.addAttribute("tileGroups",this.tileGroupRepository.findAll());
        return "cms/tileGroup/list";
    }

}
