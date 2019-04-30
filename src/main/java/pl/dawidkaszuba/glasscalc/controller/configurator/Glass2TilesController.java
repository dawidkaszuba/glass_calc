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

    @Autowired
    private StandardPrice2TilesGlassRepository standardPrice2TilesGlassRepository;

    @Autowired
    private TileGroupRepository tileGroupRepository;

    @Autowired FrameGroupRepository frameGroupRepository;

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


            glass2Tiles.setThickness();
            glass2Tiles.setName();
            glass2Tiles.setWeight();
            glass2Tiles.getDeliveryTime();
            double price = getPrice(glass2Tiles);
            glass2Tiles.setPrice(price);
            this.glass2TilesRepository.save(glass2Tiles);
            return "redirect:/configurator2Tiles/list";

        }else{

            model.addAttribute("errors",glass2Tiles.checkIsCorrect());
            model.addAttribute("glass2", new Glass2Tiles());
            return "configurator/glass2Tiles/configure2TileGlass";
        }
    }

    @GetMapping("/edit/{id}")
    public String editGlass2Tiles(@PathVariable Long id, Model model){
        model.addAttribute("glass2",this.glass2TilesRepository.findOne(id));
        return "configurator/glass2Tiles/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedGlass2Tiles(@Valid Glass2Tiles glass2Tiles, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/configurator2Tiles/edit/" + glass2Tiles.getId();
        }else if(glass2Tiles.checkIsCorrect().size()==0){

            glass2Tiles.setName();
            glass2Tiles.setThickness();
            glass2Tiles.getDeliveryTime();
            glass2Tiles.setWeight();
            double price = getPrice(glass2Tiles);
            glass2Tiles.setPrice(price);

            this.glass2TilesRepository.save(glass2Tiles);
            return "redirect:/configurator2Tiles/list";
        }else{
            model.addAttribute("errors",glass2Tiles.checkIsCorrect());
            model.addAttribute("glass2", this.glass2TilesRepository.findOne(glass2Tiles.getId()));
            return "configurator/glass2Tiles/edit";
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


    private double getPrice(Glass2Tiles glass2Tiles){

        if((glass2Tiles.getExternalTile().getPrice() + glass2Tiles.getInternalTile().getPrice() +
                glass2Tiles.getGas().getPrice()) == 0) {
            if(! glass2Tiles.checkIfAreaLowerThen04()) {

                return ((this.standardPrice2TilesGlassRepository.findOne(1L).getValue()
                        + glass2Tiles.getFrame().getPrice()) / 1000000
                        * (glass2Tiles.getWidth() * glass2Tiles.getHeight()))
                        * glass2Tiles.getHowIncreasePriceDependOnDimensions();
            }else {

                return (this.standardPrice2TilesGlassRepository.findOne(1L).getValue()
                        + glass2Tiles.getFrame().getPrice()) * 0.4;

                }
            }else{

            if(! glass2Tiles.checkIfAreaLowerThen04()) {

                return ((basePrice2TileRepository.findOne(1L).getValue() + glass2Tiles.getFrame().getPrice() +
                        glass2Tiles.getExternalTile().getPrice()
                        + glass2Tiles.getInternalTile().getPrice() + glass2Tiles.getGas().getPrice())
                        / 1000000 * (glass2Tiles.getWidth() * glass2Tiles.getHeight()))
                        * glass2Tiles.getHowIncreasePriceDependOnDimensions();
            }else {

                return (basePrice2TileRepository.findOne(1L).getValue() + glass2Tiles.getFrame().getPrice() +
                        glass2Tiles.getExternalTile().getPrice()
                        + glass2Tiles.getInternalTile().getPrice() + glass2Tiles.getGas().getPrice()) * 0.4;

            }
        }


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
