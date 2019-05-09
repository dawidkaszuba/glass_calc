package pl.dawidkaszuba.glasscalc.controller.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.glasscalc.entity.Frame;
import pl.dawidkaszuba.glasscalc.entity.FrameGroup;
import pl.dawidkaszuba.glasscalc.repository.FrameGroupRepository;
import pl.dawidkaszuba.glasscalc.repository.FrameRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/frame")
public class FrameController {

    private final FrameRepository frameRepository;

    private final FrameGroupRepository frameGroupRepository;

    @Autowired
    public FrameController(FrameRepository frameRepository, FrameGroupRepository frameGroupRepository) {
        this.frameRepository = frameRepository;
        this.frameGroupRepository = frameGroupRepository;
    }

    @GetMapping("/add")
    public String addFrame(Model model){
        model.addAttribute("frame", new Frame());
        return "cms/frame/add";
    }
    @PostMapping("/add")
    public String saveFrame(@Valid Frame frame, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cms/frame/add";
        }else{
            this.frameRepository.save(frame);
            return "redirect:/frame/list";
        }
    }
    @GetMapping("/list")
    public String findAllFrame(Model model){
        model.addAttribute("frames", this.frameRepository.findAll());
        return "cms/frame/list";
    }
    @GetMapping("delete/{id}")
    public String deleteFrame(@PathVariable Long id){
        this.frameRepository.delete(this.frameRepository.findOne(id));
        return "redirect:/frame/list";
    }
    @GetMapping("/edit/{id}")
    public String editFrame(@PathVariable Long id, Model model){
        model.addAttribute("frame", this.frameRepository.findOne(id));
        return "cms/frame/edit";
    }
    @PostMapping("/saveEdited")
    public String saveEditedFrame(@Valid Frame frame, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/frame/edit/"+frame.getId();
        }else{
            this.frameRepository.save(frame);
            return "redirect:/frame/list";
        }
    }

    @GetMapping("/findByName")
    public String findByName(@RequestParam String name,Model model){
        model.addAttribute("frames",this.frameRepository.findAllByNameContainingIgnoreCase(name));
        return "cms/frame/list";
    }

    @GetMapping("/allByGroupId/{id}")
    @ResponseBody
    public List<Frame> findAllByTileGroupId(@PathVariable Long id){
        return this.frameRepository.findAllByGroupId(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Frame findFrameById(@PathVariable Long id){
        return this.frameRepository.findOne(id);
    }

    @ModelAttribute("frameGroups")
    public List<FrameGroup> findAllFrame(){
        return this.frameGroupRepository.findAll();
    }
}
