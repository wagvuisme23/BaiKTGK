package com.example.BaiKTGK.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    private String maNV;

    private String tenNV;
    private String phai;
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "maPhong")
    private PhongBan phongBan;

    private int luong;
}
