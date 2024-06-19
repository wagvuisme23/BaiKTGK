package com.example.BaiKTGK.service;

import com.example.BaiKTGK.model.PhongBan;
import com.example.BaiKTGK.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {

    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBans() {
        return phongBanRepository.findAll();
    }

    public void addPhongBan(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    public PhongBan getPhongBan(String id) {
        Optional<PhongBan> phongBan = phongBanRepository.findById(id);
        return phongBan.orElse(null);
    }

    public void updatePhongBan(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    public void deletePhongBan(String id) {
        phongBanRepository.deleteById(id);
    }
}
