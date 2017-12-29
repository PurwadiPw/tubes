package com.tubes.controller;

import com.tubes.model.Kelas;
import com.tubes.service.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KelasController {

    private KelasService kelasService;

    @Autowired
    public void setKelasService(KelasService kelasService) {
        this.kelasService = kelasService;
    }

    @RequestMapping(value = "/kelas", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("kelass", kelasService.listAllKelass());
        System.out.println("Returning rpoducts:");
        return "admin/kelas/list";
    }

    @RequestMapping("kelas/{nm}")
    public String showKelas(@PathVariable String nm, Model model) {
        model.addAttribute("kelas", kelasService.getKelasByNm(nm));
        return "admin/kelas/show";
    }

    @RequestMapping("kelas/edit/{nm}")
    public String edit(@PathVariable String nm, Model model) {
        model.addAttribute("kelas", kelasService.getKelasByNm(nm));
        return "admin/kelas/form";
    }

    @RequestMapping("kelas/new")
    public String newKelas(Model model) {
        model.addAttribute("kelas", new Kelas());
        return "admin/kelas/form";
    }

    @RequestMapping(value = "kelas", method = RequestMethod.POST)
    public String saveKelas(Kelas kelas) {
        kelasService.saveKelas(kelas);
        return "redirect:/kelas/" + kelas.getNmKelas();
    }

    @RequestMapping("kelas/delete/{nm}")
    public String delete(@PathVariable String nm) {
        kelasService.deleteKelas(nm);
        return "redirect:/kelas";
    }
    
    @ModelAttribute("section")
    public String section() {
        return "kelas";
    }

}
