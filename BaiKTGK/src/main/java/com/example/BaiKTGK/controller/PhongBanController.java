package com.example.BaiKTGK.controller;

import com.example.BaiKTGK.model.PhongBan;
import com.example.BaiKTGK.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping("/phongbans")
    public String getAllPhongBans(Model model) {
        List<PhongBan> phongBans = phongBanService.getAllPhongBans();
        model.addAttribute("phongBans", phongBans);
        return "phongbans/phongbans";
    }

    @GetMapping("/phongbans/add")
    public String addPhongBanForm(Model model) {
        model.addAttribute("phongBan", new PhongBan());
        return "phongbans/add-phongban";
    }

    @PostMapping("/phongbans/add")
    public String addPhongBan(@ModelAttribute PhongBan phongBan) {
        phongBanService.addPhongBan(phongBan);
        return "redirect:/phongbans";
    }

    @GetMapping("/phongbans/edit/{id}")
    public String editPhongBanForm(@PathVariable String id, Model model) {
        PhongBan phongBan = phongBanService.getPhongBan(id);
        model.addAttribute("phongBan", phongBan);
        return "phongbans/edit-phongban";
    }

    @PostMapping("/phongbans/edit")
    public String editPhongBan(@ModelAttribute PhongBan phongBan) {
        phongBanService.updatePhongBan(phongBan);
        return "redirect:/phongbans";
    }

    @GetMapping("/phongbans/delete/{id}")
    public String deletePhongBan(@PathVariable String id) {
        phongBanService.deletePhongBan(id);
        return "redirect:/phongbans";
    }
}
