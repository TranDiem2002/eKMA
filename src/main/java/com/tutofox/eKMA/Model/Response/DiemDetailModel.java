package com.tutofox.eKMA.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiemDetailModel {
    private int diemID;

    private String tenMonHoc;

    private String hocKi;

    private double diemTP1;

    private double diemTP2;

    private double diemKT;

    private double diemTK;

    private String diemChu;
}
