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

    @GetMapping("/add")
    public String addGlass2TilesForm(Model model){
        model.addAttribute("glass2", new Glass2Tiles());
        return "configurator/glass2Tiles/configure2TileGlass";
    }

    @PostMapping("/add")
    public String saveGlass2Tiles(@Valid Glass2Tiles glass2Tiles, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){

            return "configurator/glass2Tiles/configure2TileGlass";

        }else if(checkIsCorrect(glass2Tiles).size()==0){


            glass2Tiles.setThickness();
            glass2Tiles.setName();
            glass2Tiles.setPrice(getPrice(glass2Tiles));
            this.glass2TilesRepository.save(glass2Tiles);
            return "redirect:/configurator2Tiles/list";

        }else{

            model.addAttribute("errors",checkIsCorrect(glass2Tiles));
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
        }else if(checkIsCorrect(glass2Tiles).size()==0){

            glass2Tiles.setName();
            glass2Tiles.setThickness();
            glass2Tiles.setPrice(getPrice(glass2Tiles));

            this.glass2TilesRepository.save(glass2Tiles);
            return "redirect:/configurator2Tiles/list";
        }else{
            model.addAttribute("errors",checkIsCorrect(glass2Tiles));
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


    private double getPrice(Glass2Tiles glass2Tiles){

        if((glass2Tiles.getExternalTile().getPrice() + glass2Tiles.getInternalTile().getPrice() +
                glass2Tiles.getGas().getPrice()) == 0) {

            return (this.standardPrice2TilesGlassRepository.findOne(1L).getValue()
                    + glass2Tiles.getFrame().getPrice()) * 0.000001*(glass2Tiles.getWidth() * glass2Tiles.getHeight());

        }else{

            return (basePrice2TileRepository.findOne(1L).getValue() + glass2Tiles.getFrame().getPrice() +
                    glass2Tiles.getExternalTile().getPrice()
                    + glass2Tiles.getInternalTile().getPrice() + glass2Tiles.getGas().getPrice())
                    * 0.000001*(glass2Tiles.getWidth() * glass2Tiles.getHeight());
        }
    }


    private List<ErrorGlass> checkIsCorrect(Glass2Tiles glass2Tiles) {

        List<ErrorGlass> errors = new ArrayList<>();

        if(checkIfhasOneLowEmislyCoating(glass2Tiles) != null){
            errors.add(checkIfhasOneLowEmislyCoating(glass2Tiles));
        }

        if(checkIfHasTwoLowEmislyCoating(glass2Tiles) != null){
            errors.add(checkIfHasTwoLowEmislyCoating(glass2Tiles));
        }
        if(checkIfHasCorrectDimension(glass2Tiles) !=null){
            errors.add(checkIfHasCorrectDimension(glass2Tiles));
        }

        return errors;
    }


    private ErrorGlass checkIfhasOneLowEmislyCoating(Glass2Tiles glass2Tiles){
        String message = " szyba jednokomorowa powinna mieć conajmniej jedną powłokę niskoemisyjną";

        if(glass2Tiles.getInternalTile().getCoating().getLowEmisly() || glass2Tiles.getExternalTile().getCoating().getLowEmisly()){
            return null;
        }else{
            return new ErrorGlass(message);
        }
    }

    private ErrorGlass checkIfHasTwoLowEmislyCoating(Glass2Tiles glass2Tiles){
        String message = "Szyba jednokomorowa powinna mieć jedną powłokę niskoemisyjną";

        if(glass2Tiles.getExternalTile().getCoating().getLowEmisly() &&
                glass2Tiles.getInternalTile().getCoating().getLowEmisly()){
            return new ErrorGlass(message);
        } else{
            return null;
        }
    }

    private Tile getThinnestTile(Glass2Tiles glass2Tiles){

        if(glass2Tiles.getInternalTile().getThickness() > glass2Tiles.getExternalTile().getThickness()) {
            return glass2Tiles.getExternalTile();
        }else{
            return glass2Tiles.getInternalTile();
        }
    }

    private double checkThicknessToCalculating(Tile tile){

        if(tile.getFoil() != null){
            double thickness = tile.getFoil().getThickness() -
                    tile.getFoil().getThickness();
            return thickness * 0.63;
        }else{
            return tile.getThickness();
        }
    }

    private ErrorGlass checkIfHasCorrectDimension(Glass2Tiles glass2Tiles){

        String for4ThicknessMessage = "przekroczony stosunek boków dla szyby 4, prawidłowy max 1:6";
        String for6ThicknessMessage = "przekroczony stosunek boków dla szyby 6 i grubszych, prawidłowy max 1:10";

        if(checkThicknessToCalculating(getThinnestTile(glass2Tiles)) >= 3.78) {
            if(glass2Tiles.getHeight() / glass2Tiles.getWidth() > 6 ) {
                return new ErrorGlass(for4ThicknessMessage);
            }else{
                return null;
            }
        } else if(checkThicknessToCalculating(getThinnestTile(glass2Tiles)) >= 5){
            if(glass2Tiles.getHeight() / glass2Tiles.getWidth() > 10 ) {
                return new ErrorGlass(for6ThicknessMessage);
            } else {
                return null;
            }

        }
        return null;
    }
}
