package com.tubes.controller;

import com.tubes.model.Sesi;
import com.tubes.service.SesiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SesiController {

    private SesiService sesiService;

    @Autowired
    public void setSesiService(SesiService sesiService) {
        this.sesiService = sesiService;
    }

    @RequestMapping(value = "/sesi", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("sesis", sesiService.listAllSesis());
        System.out.println("Returning rpoducts:");
        return "admin/sesi/list";
    }

    @RequestMapping("sesi/{id}")
    public String showSesi(@PathVariable Integer id, Model model) {
        model.addAttribute("sesi", sesiService.getSesiById(id));
        return "admin/sesi/show";
    }

    @RequestMapping("sesi/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("sesi", sesiService.getSesiById(id));
        return "admin/sesi/form";
    }

    @RequestMapping("sesi/new")
    public String newSesi(Model model) {
        model.addAttribute("sesi", new Sesi());
        return "admin/sesi/form";
    }

    @RequestMapping(value = "sesi", method = RequestMethod.POST)
    public String saveSesi(Sesi sesi) {
        sesiService.saveSesi(sesi);
        return "redirect:/sesi/" + sesi.getIdSesi();
    }

    @RequestMapping("sesi/delete/{id}")
    public String delete(@PathVariable Integer id) {
        sesiService.deleteSesi(id);
        return "redirect:/sesi";
    }
    
    @ModelAttribute("section")
    public String section() {
        return "sesi";
    }

}
