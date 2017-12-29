package com.tubes.controller;

//import com.tubes.model.Dosen;
//import com.tubes.service.DosenService;

import com.tubes.model.Dosen;
import com.tubes.service.DosenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DosenController {

    private DosenService dosenService;

    @Autowired
    public void setDosenService(DosenService dosenService) {
        this.dosenService = dosenService;
    }

    @RequestMapping(value = "/dosen", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("dosens", dosenService.listAllDosens());
        System.out.println("Returning rpoducts:");
        return "admin/dosen/list";
    }

    @RequestMapping("dosen/{kd}")
    public String showDosen(@PathVariable String kd, Model model) {
        model.addAttribute("dosen", dosenService.getDosenByKd(kd));
        return "admin/dosen/show";
    }

    @RequestMapping("dosen/edit/{kd}")
    public String edit(@PathVariable String kd, Model model) {
        model.addAttribute("dosen", dosenService.getDosenByKd(kd));
        return "admin/dosen/form";
    }

    @RequestMapping("dosen/new")
    public String newDosen(Model model) {
        model.addAttribute("dosen", new Dosen());
        return "admin/dosen/form";
    }

    @RequestMapping(value = "dosen", method = RequestMethod.POST)
    public String saveDosen(Dosen dosen) {
        dosenService.saveDosen(dosen);
        return "redirect:/dosen/" + dosen.getKdDosen();
    }

    @RequestMapping("dosen/delete/{kd}")
    public String delete(@PathVariable String kd) {
        dosenService.deleteDosen(kd);
        return "redirect:/dosen";
    }
    
    @ModelAttribute("section")
    public String section() {
        return "dosen";
    }

}
