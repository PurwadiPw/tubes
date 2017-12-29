package com.tubes.controller;

import com.tubes.model.Ruang;
import com.tubes.service.RuangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RuangController {

    private RuangService ruangService;

    @Autowired
    public void setRuangService(RuangService ruangService) {
        this.ruangService = ruangService;
    }

    @RequestMapping(value = "/ruang", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("ruangs", ruangService.listAllRuangs());
        System.out.println("Returning rpoducts:");
        return "admin/ruang/list";
    }

    @RequestMapping("ruang/{kd}")
    public String showRuang(@PathVariable String kd, Model model) {
        model.addAttribute("ruang", ruangService.getRuangByKd(kd));
        return "admin/ruang/show";
    }

    @RequestMapping("ruang/edit/{kd}")
    public String edit(@PathVariable String kd, Model model) {
        model.addAttribute("ruang", ruangService.getRuangByKd(kd));
        return "admin/ruang/form";
    }

    @RequestMapping("ruang/new")
    public String newRuang(Model model) {
        model.addAttribute("ruang", new Ruang());
        return "admin/ruang/form";
    }

    @RequestMapping(value = "ruang", method = RequestMethod.POST)
    public String saveRuang(Ruang ruang) {
        ruangService.saveRuang(ruang);
        return "redirect:/ruang/" + ruang.getKdRuang();
    }

    @RequestMapping("ruang/delete/{kd}")
    public String delete(@PathVariable String kd) {
        ruangService.deleteRuang(kd);
        return "redirect:/ruang";
    }
    
    @ModelAttribute("section")
    public String section() {
        return "ruang";
    }

}
