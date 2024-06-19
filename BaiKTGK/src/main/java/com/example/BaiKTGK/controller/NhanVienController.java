package com.example.BaiKTGK.controller;

import com.example.BaiKTGK.model.NhanVien;
import com.example.BaiKTGK.model.PhongBan;
import com.example.BaiKTGK.service.NhanVienService;
import com.example.BaiKTGK.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping("/nhanviens")
    public String getAllNhanViens(Model model) {
        List<NhanVien> nhanViens = nhanVienService.getAllNhanViens();
        model.addAttribute("nhanViens", nhanViens);
        return "nhanviens/nhanviens";
    }

    @GetMapping("/nhanviens/add")
    public String addNhanVienForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "nhanviens/add-nhanvien";
    }

    @PostMapping("/nhanviens/add")
    public String addNhanVien(@ModelAttribute NhanVien nhanVien) {
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/nhanviens/edit/{id}")
    public String editNhanVienForm(@PathVariable String id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVien(id);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "nhanviens/edit-nhanvien";
    }

    @PostMapping("/nhanviens/edit")
    public String editNhanVien(@ModelAttribute NhanVien nhanVien) {
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/nhanviens/delete/{id}")
    public String deleteNhanVien(@PathVariable String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }
}
