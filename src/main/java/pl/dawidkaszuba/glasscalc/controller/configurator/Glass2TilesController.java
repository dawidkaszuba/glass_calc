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
@RequestMapping("/configurator2Tiles")
public class Glass2TilesController {

    @Autowired
    private FrameRepository frameRepository;

    @Autowired
    private TileRepository tileRepository;

    @Autowired
    private Glass2TilesRepository glass2TilesRepository;

    @Autowired
    BasePrice2TileRepository basePrice2TileRepository;

    @Autowired
    private GasRepository gasRepository;

    @GetMapping("/add")
    public String addGlass2TilesForm(Model model){
        model.addAttribute("glass2", new Glass2Tiles());
        return "configurator/glass2Tiles/configure2TileGlass";
    }

    @PostMapping("/add")
    public String saveGlass2Tiles(@Valid Glass2Tiles glass2Tiles, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "configurator/glass2Tiles/configure2TileGlass";
        }else{
            glass2Tiles.setName();
            glass2Tiles.setPrice(getPrice(glass2Tiles.getExternalTile(),glass2Tiles.getInternalTile(),
                                 glass2Tiles.getFrame(),glass2Tiles.getGas()));
            this.glass2TilesRepository.save(glass2Tiles);
            return "redirect:/configurator2Tiles/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editGlass2Tiles(@PathVariable Long id, Model model){
        model.addAttribute("glass2",this.glass2TilesRepository.findOne(id));
        return "configurator/glass2Tiles/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedGlass2Tiles(@Valid Glass2Tiles glass2Tiles, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/configurator2Tiles/edit/" + glass2Tiles.getId();
        }else{
            glass2Tiles.setName();
            glass2Tiles.setPrice(getPrice(glass2Tiles.getExternalTile(),glass2Tiles.getInternalTile(),
                                 glass2Tiles.getFrame(),glass2Tiles.getGas()));
            this.glass2TilesRepository.save(glass2Tiles);
            return "redirect:/configurator2Tiles/list";
        }

    }

    @GetMapping("/list")
    public String findAllGlass2Tiles(Model model){
        model.addAttribute("glasses2", this.glass2TilesRepository.findAll());
        return "configurator/glass2Tiles/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteGlass2Tiles(@PathVariable Long id){
        this.glass2TilesRepository.delete(id);
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

    private double getPrice(Tile externalTile, Tile internalTile, Frame frame, Gas gas){

        BasePrice2Tile basePrice2Tiles = this.basePrice2TileRepository.findOne(1l);

        return basePrice2Tiles.getValue() + externalTile.getPrice() + internalTile.getPrice()
                + frame.getPrice() + gas.getPrice();
    }

    private boolean checkIfhasOneLowEmislyCoating(Glass2Tiles glass2Tiles){
        if(glass2Tiles.getInternalTile().getCoating().getLowEmisly() || glass2Tiles.getExternalTile().getCoating().getLowEmisly()){
            return true;
        }else{
            return false;
        }
    }


}
