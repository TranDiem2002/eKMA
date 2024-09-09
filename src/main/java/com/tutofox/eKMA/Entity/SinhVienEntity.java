package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sinhvienKMA")
public class SinhVienEntity {

    @Id
    @Column(name = "maSV")
    private String maSV;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @ManyToOne
    @JoinColumn(name = "lopCQId")
    private LopCQEntity lopCQId;

    @Column(name = "he")
    private String he;

    @Column(name = "truong")
    private  String truong;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "lophoc_sinhvien",joinColumns = @JoinColumn(name = "maSV"), inverseJoinColumns = @JoinColumn(name = "lophocID"))
    private List<LopHocEntity> dslop;

    @ManyToMany
    @JoinTable(name = "diemSV", joinColumns = @JoinColumn(name = "maSV"), inverseJoinColumns = @JoinColumn(name = "diemID"))
    private List<DiemEntity> listDiem;
}
