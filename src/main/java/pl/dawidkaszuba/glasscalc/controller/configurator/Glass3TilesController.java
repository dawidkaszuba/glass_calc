package pl.dawidkaszuba.glasscalc.controller.configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.*;
import pl.dawidkaszuba.glasscalc.errors.ErrorGlass;
import pl.dawidkaszuba.glasscalc.repository.*;

import javax.validation.Valid;
import java.util.ArrayList;
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

    @Autowired
    private StandardPrice3TilesGlassRepository standardPrice3TilesGlassRepository;

    @GetMapping("/add")
    public String addGlass3TilesForm(Model model) {
        model.addAttribute("glass3", new Glass3Tiles());
        return "configurator/glass3Tiles/configure3TileGlass";
    }

    @PostMapping("/add")
    public String saveGlass3Tiles(@Valid Glass3Tiles glass3Tiles, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            return "configurator3Tiles/add";

        } else if(checkIsCorrect(glass3Tiles).size()==0) {

            glass3Tiles.setName();
            glass3Tiles.setThickness();
            glass3Tiles.setPrice(getPrice(glass3Tiles));
            this.glass3TilesRepository.save(glass3Tiles);
            return "redirect:/configurator3Tiles/list";

        }else{
            model.addAttribute("errors",checkIsCorrect(glass3Tiles));
            model.addAttribute("glass3", new Glass3Tiles());
            return "configurator/glass3Tiles/configure3TileGlass";
        }
    }

    @GetMapping("/edit/{id}")
    public String editGlass3Tiles(@PathVariable Long id, Model model ) {
        model.addAttribute("glass3", this.glass3TilesRepository.findOne(id));
        return "configurator/glass3Tiles/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedGlass3Tiles(@Valid Glass3Tiles glass3Tiles, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/configurator3Tiles/edit/" + glass3Tiles.getId();

        } else if(checkIsCorrect(glass3Tiles).size()==0) {

            glass3Tiles.setThickness();
            glass3Tiles.setName();
            glass3Tiles.setPrice(getPrice(glass3Tiles));
            this.glass3TilesRepository.save(glass3Tiles);
            return "redirect:/configurator3Tiles/list";
        }else{

            model.addAttribute("errors",checkIsCorrect(glass3Tiles));
            model.addAttribute("glass3", this.glass3TilesRepository.findOne(glass3Tiles.getId()));
            return "configurator/glass3Tiles/edit";

        }

    }

    @GetMapping("/list")
    public String findAllGlass2Tiles(Model model) {
        model.addAttribute("glasses3", this.glass3TilesRepository.findAll());
        return "configurator/glass3Tiles/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteGlass3Tiles(@PathVariable Long id) {
        this.glass3TilesRepository.delete(id);
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


    private double getPrice(Glass3Tiles glass3Tiles) {

        if((glass3Tiles.getExternalTile().getPrice()+ glass3Tiles.getMiddleTile().getPrice()
                + glass3Tiles.getInternalTile().getPrice() + glass3Tiles.getGas().getPrice())==0){

            return (this.standardPrice3TilesGlassRepository.findOne(1L).getValue()
                    + glass3Tiles.getFirstFrame().getPrice() + glass3Tiles.getSecondFrame().getPrice())
                    * 0.000001*(glass3Tiles.getWidth() * glass3Tiles.getHeight());
        }else {

            BasePrice3Tile basePrice3Tiles = this.basePrice3TileRepository.findOne(1L);

            return (basePrice3Tiles.getValue() + glass3Tiles.getMiddleTile().getPrice()
                    + glass3Tiles.getExternalTile().getPrice() +
                    glass3Tiles.getInternalTile().getPrice() + glass3Tiles.getFirstFrame().getPrice()
                    + glass3Tiles.getSecondFrame().getPrice() + (2 * glass3Tiles.getGas().getPrice()))
                    * 0.000001*(glass3Tiles.getWidth() * glass3Tiles.getHeight());
        }
    }


    private List<ErrorGlass> checkIsCorrect(Glass3Tiles glass3Tiles) {

        List<ErrorGlass> errors = new ArrayList<>();

       if(checkIfHasTwoLowEmislyCoatings(glass3Tiles) != null){
           errors.add(checkIfHasTwoLowEmislyCoatings(glass3Tiles));
       }
       if(checkIfMiddleTileIsTempered(glass3Tiles) != null){
           errors.add(checkIfMiddleTileIsTempered(glass3Tiles));
       }

        return errors;
    }


    private ErrorGlass checkIfHasTwoLowEmislyCoatings(Glass3Tiles glass3Tiles){

        String twoLowEmislyMessage ="potrójna szyba wymaga  dwóch powłok niskoemisyjnych";
        ErrorGlass error = new ErrorGlass(twoLowEmislyMessage);
        List<Boolean> quantityLowEmislyCoatings = new ArrayList<>();
        int counter=0;

        quantityLowEmislyCoatings.add(glass3Tiles.getExternalTile().getCoating().getLowEmisly());
        quantityLowEmislyCoatings.add(glass3Tiles.getInternalTile().getCoating().getLowEmisly());
        quantityLowEmislyCoatings.add(glass3Tiles.getMiddleTile().getCoating().getLowEmisly());

        for(int i = 0; i< quantityLowEmislyCoatings.size();i++){
            if(quantityLowEmislyCoatings.get(i)){
               counter+=1;
            }
        }

        if(counter<2){
            return error;
        }else{
            return null;
        }

    }

    private ErrorGlass checkIfMiddleTileIsTempered(Glass3Tiles glass3Tiles){

        String middleLowEmislyShouldBeTempered = "Wewnętrzna tafla jeśli ma powłokę niskoemisyjną musi byc hartowana";
        boolean middleTileCoating = glass3Tiles.getMiddleTile().getCoating().getLowEmisly();

        if(middleTileCoating){
            return new ErrorGlass(middleLowEmislyShouldBeTempered);
        }else{
            return null;
        }
    }


}
