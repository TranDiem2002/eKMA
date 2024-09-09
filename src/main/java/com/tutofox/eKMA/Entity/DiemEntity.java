package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "diem")
public class DiemEntity {

    @Id
    @GeneratedValue
    @Column(name = "diemID")
    private int diemID;

    @ManyToOne
    private MonHocEntity monhocID;

    private double diemTP1;

    private double diemTP2;

    private double diemKT;

    private double diemTK;

    private String diemChu;
}
