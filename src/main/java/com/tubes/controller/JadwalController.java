package com.tubes.controller;

import com.tubes.model.Jadwal;
import com.tubes.service.JadwalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JadwalController {

    private JadwalService jadwalService;

    @Autowired
    public void setJadwalService(JadwalService jadwalService) {
        this.jadwalService = jadwalService;
    }

    @RequestMapping(value = "/jadwal", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("jadwals", jadwalService.listAllJadwals());
        System.out.println("Returning rpoducts:");
        return "admin/jadwal/list";
    }

    @RequestMapping("jadwal/{kd}")
    public String showJadwal(@PathVariable String kd, Model model) {
        model.addAttribute("jadwal", jadwalService.getJadwalByKd(kd));
        return "admin/jadwal/show";
    }

    @RequestMapping("jadwal/edit/{kd}")
    public String edit(@PathVariable String kd, Model model) {
        model.addAttribute("jadwal", jadwalService.getJadwalByKd(kd));
        return "admin/jadwal/form";
    }

    @RequestMapping("jadwal/new")
    public String newJadwal(Model model) {
        model.addAttribute("jadwal", new Jadwal());
        return "admin/jadwal/form";
    }

    @RequestMapping(value = "jadwal", method = RequestMethod.POST)
    public String saveJadwal(Jadwal jadwal) {
        jadwalService.saveJadwal(jadwal);
        return "redirect:/jadwal/" + jadwal.getKdJadwal();
    }

    @RequestMapping("jadwal/delete/{kd}")
    public String delete(@PathVariable String kd) {
        jadwalService.deleteJadwal(kd);
        return "redirect:/jadwal";
    }
    
    @ModelAttribute("section")
    public String section() {
        return "jadwal";
    }

}
