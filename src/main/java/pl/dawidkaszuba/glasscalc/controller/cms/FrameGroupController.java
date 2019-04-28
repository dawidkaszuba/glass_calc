package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.FrameGroup;
import pl.dawidkaszuba.glasscalc.repository.FrameGroupRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/frameGroup")
public class FrameGroupController {

    @Autowired
    private FrameGroupRepository frameGroupRepository;

    @GetMapping("/add")
    public String addFrameGroupForm(Model model){
        model.addAttribute("frameGroup", new FrameGroup());
        return "cms/frameGroup/add";
    }

    @PostMapping("/add")
    public String saveFrameGroup(@Valid FrameGroup frameGroup, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/frameGroup/add";
        }else{
            this.frameGroupRepository.save(frameGroup);
            return "redirect:/frameGroup/list";
        }
    }

    @GetMapping("/list")
    public String findAllFrameGroup(Model model){
        model.addAttribute("frameGroups", this.frameGroupRepository.findAll());
        return "cms/frameGroup/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteFrameGroup(@PathVariable Long id){
        this.frameGroupRepository.delete(id);
        return "redirect:/frameGroup/list";
    }

    @GetMapping("/edit/{id}")
    public String editFrameGroupForm(@PathVariable Long id, Model model){
        model.addAttribute("frameGroup", this.frameGroupRepository.findOne(id));
        return "cms/frameGroup/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedFrameGroup(@Valid FrameGroup frameGroup, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/frameGroup/edit/"+frameGroup.getId();
        }else{
            this.frameGroupRepository.save(frameGroup);
            return "redirect:/frameGroup/list";
        }
    }

}
