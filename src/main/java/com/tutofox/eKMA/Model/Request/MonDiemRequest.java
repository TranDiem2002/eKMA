package com.tutofox.eKMA.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonDiemRequest {

    private int monhocID;

    private List<SinhVienDiemRequest> sinhVienDiemRequests;
}
