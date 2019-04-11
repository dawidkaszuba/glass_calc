package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.glasscalc.entity.Gas;
import pl.dawidkaszuba.glasscalc.repository.GasRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/gas")
public class GasController {

    @Autowired
    private GasRepository gasRepository;

    @GetMapping("add")
    public String addGasForm(Model model){
        model.addAttribute("gas", new Gas());
        return "cms/gas/add";
    }
    @PostMapping("/add")
    public String addGas(@Valid Gas gas, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cms/gas/add";
        }else{
            this.gasRepository.save(gas);
            return "redirect:/gas/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editGasForm(@PathVariable Long id, Model model){
        model.addAttribute("gas", this.gasRepository.findOne(id));
        return "cms/gas/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEdited(@Valid Gas gas, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/gas/edit/"+gas.getId();
        }else {
            this.gasRepository.save(gas);
            return "redirect:/gas/list";
        }
    }

    @GetMapping("/list")
    public String findAllGasses(Model model){
        model.addAttribute("gasses", this.gasRepository.findAll());
        return "cms/gas/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteGas(@PathVariable Long id){
        this.gasRepository.delete(id);
        return "redirect:/gas/list";
    }
}
