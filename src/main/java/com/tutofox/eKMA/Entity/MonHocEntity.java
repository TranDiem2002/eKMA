package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "monhoc")
public class MonHocEntity {

    @Id
    @GeneratedValue
    @Column(name = "monhocID")
    private int monhocID;

    @Column(name = "tenMonHoc")
    private String tenMonHoc;

    @Column(name = "soTinChi")
    private int soTinChi;

    @Column(name = "hocki")
    private int hocki;

    @OneToMany(mappedBy = "monhocID")
    private List<LopHocEntity> dsLop;

    @OneToMany(mappedBy = "monhocID")
    private List<DiemEntity> dsDiem;
}
