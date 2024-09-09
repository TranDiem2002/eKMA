package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "giangvien")
public class GiangVien {

    @Id
    @Column(name = "maGV")
    private String maGV;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @ManyToOne
    @JoinColumn(name = "khoaID")
    private KhoaEntity khoaID;
}
