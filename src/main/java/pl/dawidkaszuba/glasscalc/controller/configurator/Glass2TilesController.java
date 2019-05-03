package pl.dawidkaszuba.glasscalc.controller.configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.*;
import pl.dawidkaszuba.glasscalc.repository.*;
import pl.dawidkaszuba.glasscalc.service.Glass2TilesService;
import pl.dawidkaszuba.glasscalc.service.Glass2TilesServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/configurator2Tiles")
public class Glass2TilesController {

    private final FrameRepository frameRepository;

    private final TileRepository tileRepository;

    private final GasRepository gasRepository;


    private final TileGroupRepository tileGroupRepository;

    private final FrameGroupRepository frameGroupRepository;

    private Glass2TilesService glass2TilesService;

    @Autowired
    public Glass2TilesController(FrameRepository frameRepository, TileRepository tileRepository, GasRepository gasRepository, TileGroupRepository tileGroupRepository, FrameGroupRepository frameGroupRepository, Glass2TilesServiceImpl glass2TilesService) {
        this.frameRepository = frameRepository;
        this.tileRepository = tileRepository;
        this.gasRepository = gasRepository;
        this.tileGroupRepository = tileGroupRepository;
        this.frameGroupRepository = frameGroupRepository;
        this.glass2TilesService = glass2TilesService;
    }

    @GetMapping("/add")
    public String addGlass2TilesForm(Model model){
        model.addAttribute("glass2", new Glass2Tiles());
        return "configurator/glass2Tiles/configure2TileGlass";
    }


    @PostMapping("/add")
    public String saveGlass2Tiles(@Valid Glass2Tiles glass2Tiles, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){

            return "configurator/glass2Tiles/configure2TileGlass";

        }else if(glass2Tiles.checkIsCorrect().size()==0){

            glass2TilesService.save(glass2Tiles);

            return "redirect:/configurator2Tiles/list";

        }else{

            model.addAttribute("errors",glass2Tiles.checkIsCorrect());
            model.addAttribute("glass2", new Glass2Tiles());
            return "configurator/glass2Tiles/configure2TileGlass";
        }
    }

    @GetMapping("/edit/{id}")
    public String editGlass2Tiles(@PathVariable Long id, Model model){
        model.addAttribute("glass2",this.glass2TilesService.findById(id));
        return "configurator/glass2Tiles/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedGlass2Tiles(@Valid Glass2Tiles glass2Tiles, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/configurator2Tiles/edit/" + glass2Tiles.getId();
        }else if(glass2Tiles.checkIsCorrect().size()==0){

            this.glass2TilesService.save(glass2Tiles);

            return "redirect:/configurator2Tiles/list";
        }else{
            model.addAttribute("errors",glass2Tiles.checkIsCorrect());
            model.addAttribute("glass2", this.glass2TilesService.findById(glass2Tiles.getId()));
            return "configurator/glass2Tiles/edit";
        }

    }

    @GetMapping("/list")
    public String findAllGlass2Tiles(Model model){
        model.addAttribute("glasses2", this.glass2TilesService.findAll());
        return "configurator/glass2Tiles/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteGlass2Tiles(@PathVariable Long id){
        this.glass2TilesService.delete(id);
        return "redirect:/configurator2Tiles/list";
    }


    @ModelAttribute("frames")
    public List<Frame> findAllFrame(){
        return this.frameRepository.findAll();
    }

    @ModelAttribute("tiles")
    public List<Tile> findAllTiles(){
        return this.tileRepository.findAll();
    }

    @ModelAttribute("gasses")
    public List<Gas> findAllGasses(){
        return this.gasRepository.findAll();
    }

    @ModelAttribute("tilesGroups")
    public List<TileGroup> findAllTileGroups(){
        return this.tileGroupRepository.findAll();
    }

    @ModelAttribute("frameGroups")
    public List<FrameGroup> findAllFrameGroups(){
        return this.frameGroupRepository.findAll();
    }


}
