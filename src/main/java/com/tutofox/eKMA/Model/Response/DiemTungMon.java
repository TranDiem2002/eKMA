package com.tutofox.eKMA.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DiemTungMon {

    private String monHoc;
    private double diemTP1;

    private double diemTP2;

    private double diemTK;

    private String diemChu;
}
