package com.tubes.controller;

import com.tubes.model.Matkul;
import com.tubes.service.MatkulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MatkulController {

    private MatkulService matkulService;

    @Autowired
    public void setMatkulService(MatkulService matkulService) {
        this.matkulService = matkulService;
    }

    @RequestMapping(value = "/matkul", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("matkuls", matkulService.listAllMatkuls());
        System.out.println("Returning rpoducts:");
        return "admin/matkul/list";
    }

    @RequestMapping("matkul/{kd}")
    public String showMatkul(@PathVariable String kd, Model model) {
        model.addAttribute("matkul", matkulService.getMatkulByKd(kd));
        return "admin/matkul/show";
    }

    @RequestMapping("matkul/edit/{kd}")
    public String edit(@PathVariable String kd, Model model) {
        model.addAttribute("matkul", matkulService.getMatkulByKd(kd));
        return "admin/matkul/form";
    }

    @RequestMapping("matkul/new")
    public String newMatkul(Model model) {
        model.addAttribute("matkul", new Matkul());
        return "admin/matkul/form";
    }

    @RequestMapping(value = "matkul", method = RequestMethod.POST)
    public String saveMatkul(Matkul matkul) {
        matkulService.saveMatkul(matkul);
        return "redirect:/matkul/" + matkul.getKdMatkul();
    }

    @RequestMapping("matkul/delete/{kd}")
    public String delete(@PathVariable String kd) {
        matkulService.deleteMatkul(kd);
        return "redirect:/matkul";
    }
    
    @ModelAttribute("section")
    public String section() {
        return "matkul";
    }

}
