package com.tutofox.eKMA.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LichHocRequest {

    private String lophocID;

    private String tenMonHoc;

    private int soTinChi;

    private int hocki;

    private List<CaHocRequest> cahoc;

    private String maGGV;
}
