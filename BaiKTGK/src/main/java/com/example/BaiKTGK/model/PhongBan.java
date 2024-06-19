package com.example.BaiKTGK.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    private String maPhong;
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan")
    private List<NhanVien> nhanViens;

}
