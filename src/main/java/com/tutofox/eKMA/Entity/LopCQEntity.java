package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "lopCQ")
public class LopCQEntity {

    @Id
    @Column(name = "lopCQId")
    private String lopCQId;

    @Column(name = "tenLop")
    private String tenLop;

    @ManyToOne
    @JoinColumn(name = "khoaID")
    private KhoaEntity khoaID;

    @OneToMany(mappedBy = "lopCQId")
    private List<SinhVienEntity> sinhvienKMA;
}
