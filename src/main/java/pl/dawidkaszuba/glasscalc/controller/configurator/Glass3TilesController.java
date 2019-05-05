package pl.dawidkaszuba.glasscalc.controller.configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.*;
import pl.dawidkaszuba.glasscalc.repository.*;
import pl.dawidkaszuba.glasscalc.service.Glass3TilesService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/configurator3Tiles")
public class Glass3TilesController {

    private final FrameRepository frameRepository;

    private final TileRepository tileRepository;

    private final GasRepository gasRepository;

    private final TileGroupRepository tileGroupRepository;

    private final FrameGroupRepository frameGroupRepository;

    private final Glass3TilesService glass3TilesService;

    @Autowired
    public Glass3TilesController(FrameRepository frameRepository, TileRepository tileRepository, GasRepository gasRepository, TileGroupRepository tileGroupRepository, FrameGroupRepository frameGroupRepository, Glass3TilesService glass3TilesService) {
        this.frameRepository = frameRepository;
        this.tileRepository = tileRepository;
        this.gasRepository = gasRepository;
        this.tileGroupRepository = tileGroupRepository;
        this.frameGroupRepository = frameGroupRepository;
        this.glass3TilesService = glass3TilesService;
    }

    @GetMapping("/add")
    public String addGlass3TilesForm(Model model) {
        model.addAttribute("glass3", new Glass3Tiles());
        return "configurator/glass3Tiles/configure3TileGlass";
    }

    @PostMapping("/add")
    public String saveGlass3Tiles(@Valid Glass3Tiles glass3Tiles, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            return "configurator3Tiles/add";

        } else if(glass3Tiles.checkIsCorrect().size() == 0) {

            this.glass3TilesService.save(glass3Tiles);
            return "redirect:/configurator3Tiles/allByUserId";

        }else{
            model.addAttribute("errors",glass3Tiles.checkIsCorrect());
            model.addAttribute("glass3", new Glass3Tiles());
            return "configurator/glass3Tiles/configure3TileGlass";
        }
    }

    @GetMapping("/edit/{id}")
    public String editGlass3Tiles(@PathVariable Long id, Model model ) {
        model.addAttribute("glass3", this.glass3TilesService.findById(id));
        return "configurator/glass3Tiles/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedGlass3Tiles(@Valid Glass3Tiles glass3Tiles, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/configurator3Tiles/edit/" + glass3Tiles.getId();

        } else if(glass3Tiles.checkIsCorrect().size()==0) {

            this.glass3TilesService.save(glass3Tiles);
            return "redirect:/configurator3Tiles/allByUserId";
        }else{

            model.addAttribute("errors",glass3Tiles.checkIsCorrect());
            model.addAttribute("glass3", this.glass3TilesService.findById(glass3Tiles.getId()));
            return "configurator/glass3Tiles/edit";

        }

    }

    @GetMapping("/list")
    public String findAllGlass2Tiles(Model model) {
        model.addAttribute("glasses3", this.glass3TilesService.findAll());
        return "configurator/glass3Tiles/list";
    }

    @GetMapping("/allByUserId")
    public String findAllByUserId(Model model){
        model.addAttribute("glasses3", this.glass3TilesService.findAllByUserId());
        return "configurator/glass3Tiles/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteGlass3Tiles(@PathVariable Long id) {
        this.glass3TilesService.delete(id);
        return "redirect:/configurator3Tiles/list";
    }

    @ModelAttribute("frames")
    public List<Frame> findAllFrame() {
        return this.frameRepository.findAll();
    }

    @ModelAttribute("tiles")
    public List<Tile> findAllTiles() {
        return this.tileRepository.findAll();
    }

    @ModelAttribute("gasses")
    public List<Gas> findAllGasses() {
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
