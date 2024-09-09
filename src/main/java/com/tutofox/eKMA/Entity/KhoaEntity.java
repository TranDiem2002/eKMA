package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "khoa")
public class KhoaEntity {

    @Id
    @GeneratedValue
    @Column(name = "khoaID")
    private int khoaID;

    @Column(name = "tenKhoa")
    private String tenKhoa;

    @OneToMany(mappedBy = "khoaID")
    private List<LopCQEntity> lopCQ;

    @OneToMany(mappedBy = "khoaID")
    private  List<GiangVien> maGV;
}
