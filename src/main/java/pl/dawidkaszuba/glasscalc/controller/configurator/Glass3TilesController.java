package pl.dawidkaszuba.glasscalc.controller.configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.*;
import pl.dawidkaszuba.glasscalc.repository.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/configurator3Tiles")
public class Glass3TilesController {

    @Autowired
    private FrameRepository frameRepository;

    @Autowired
    private TileRepository tileRepository;

    @Autowired
    private Glass3TilesRepository glass3TilesRepository;

    @Autowired
    private BasePrice3TileRepository basePrice3TileRepository;

    @Autowired
    private GasRepository gasRepository;

    @GetMapping("/add")
    public String addGlass3TilesForm(Model model){
        model.addAttribute("glass3", new Glass3Tiles());
        return "configurator/glass3Tiles/configure3TileGlass";
    }

    @PostMapping("/add")
    public String saveGlass3Tiles(@Valid Glass3Tiles glass3Tiles, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "configurator/glass3Tiles/configure3TileGlass";
        }else{
            glass3Tiles.setName();
            glass3Tiles.setPrice(getPrice(glass3Tiles.getExternalTile(),glass3Tiles.getFirstFrame(),glass3Tiles.getMiddleTile(),
                    glass3Tiles.getSecondFrame(),glass3Tiles.getInternalTile(),glass3Tiles.getGas()));
            this.glass3TilesRepository.save(glass3Tiles);
            return "redirect:/configurator3Tiles/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editGlass3Tiles(@PathVariable Long id, Model model){
        model.addAttribute("glass3",this.glass3TilesRepository.findOne(id));
        return "configurator/glass3Tiles/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedGlass3Tiles(@Valid Glass3Tiles glass3Tiles, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/configurator3Tiles/edit/" + glass3Tiles.getId();
        }else{
            glass3Tiles.setName();
            glass3Tiles.setPrice(getPrice(glass3Tiles.getExternalTile(),glass3Tiles.getFirstFrame(),glass3Tiles.getMiddleTile(),
                    glass3Tiles.getSecondFrame(),glass3Tiles.getInternalTile(),glass3Tiles.getGas()));
            this.glass3TilesRepository.save(glass3Tiles);
            return "redirect:/configurator3Tiles/list";
        }

    }

    @GetMapping("/list")
    public String findAllGlass2Tiles(Model model){
        model.addAttribute("glasses3", this.glass3TilesRepository.findAll());
        return "configurator/glass3Tiles/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteGlass3Tiles(@PathVariable Long id){
        this.glass3TilesRepository.delete(id);
        return "redirect:/configurator3Tiles/list";
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

    private double getPrice(Tile externalTile, Frame firstFrame,Tile middlelTile, Frame secondFrame, Tile internalTile,Gas gas ){

        BasePrice3Tile basePrice3Tiles = this.basePrice3TileRepository.findOne(1l);

        return basePrice3Tiles.getValue() + middlelTile.getPrice() + externalTile.getPrice() +
                internalTile.getPrice() + firstFrame.getPrice() + secondFrame.getPrice() + (2 * gas.getPrice());
    }

}
