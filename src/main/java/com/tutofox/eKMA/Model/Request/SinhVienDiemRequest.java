package com.tutofox.eKMA.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienDiemRequest {

    private String maSV;

    private String hoTen;

    private double diemTP1;

    private double diemTP2;

    private double diemKT;
}
