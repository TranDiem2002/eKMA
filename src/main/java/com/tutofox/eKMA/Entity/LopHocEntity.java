package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lophocTC")
public class LopHocEntity {

    @Id
    @Column(name = "lophocID")
    private String lophocID;

    @ManyToOne
    @JoinColumn(name = "monhocID")
    private MonHocEntity monhocID;

    private StatusStudy statusStudy;

    @OneToOne
    @JoinColumn(name = "ma")
    private GiangVien maGV;

    @ManyToMany
    @JoinTable(name = "lophoc_cahoc", joinColumns = @JoinColumn(name = "lophocID"), inverseJoinColumns = @JoinColumn(name = "cahocID"))
    private List<CahocEntity> cahoc;

}
