package com.example.BaiKTGK.service;

import com.example.BaiKTGK.model.NhanVien;
import com.example.BaiKTGK.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanViens() {
        return nhanVienRepository.findAll();
    }

    public NhanVien getNhanVien(String id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public void addNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void updateNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(String id) {
        nhanVienRepository.deleteById(id);
    }
}
