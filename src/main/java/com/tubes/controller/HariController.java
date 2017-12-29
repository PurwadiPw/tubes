package com.tubes.controller;

import com.tubes.model.Hari;
import com.tubes.service.HariService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HariController {

    private HariService hariService;

    @Autowired
    public void setHariService(HariService hariService) {
        this.hariService = hariService;
    }

    @RequestMapping(value = "/hari", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("haris", hariService.listAllHaris());
        System.out.println("Returning rpoducts:");
        return "admin/hari/list";
    }

    @RequestMapping("hari/{id}")
    public String showHari(@PathVariable String id, Model model) {
        model.addAttribute("hari", hariService.getHariById(id));
        return "admin/hari/show";
    }

    @RequestMapping("hari/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("hari", hariService.getHariById(id));
        return "admin/hari/form";
    }

    @RequestMapping("hari/new")
    public String newHari(Model model) {
        model.addAttribute("hari", new Hari());
        return "admin/hari/form";
    }

    @RequestMapping(value = "hari", method = RequestMethod.POST)
    public String saveHari(Hari hari) {
        hariService.saveHari(hari);
        return "redirect:/hari/" + hari.getIdHari();
    }

    @RequestMapping("hari/delete/{id}")
    public String delete(@PathVariable String id) {
        hariService.deleteHari(id);
        return "redirect:/hari";
    }
    
    @ModelAttribute("section")
    public String section() {
        return "hari";
    }

}
