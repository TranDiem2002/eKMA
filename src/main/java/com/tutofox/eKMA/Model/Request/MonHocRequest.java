package com.tutofox.eKMA.Model.Request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonHocRequest {

    private String tenMonHoc;

    private int soTinChi;

    private int hocki;
}
