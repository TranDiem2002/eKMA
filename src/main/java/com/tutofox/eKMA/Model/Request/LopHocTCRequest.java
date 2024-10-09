package com.tutofox.eKMA.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LopHocTCRequest {

    private String lophocID;

    private List<SinhVienRequest> sinhVienRequests;
}
