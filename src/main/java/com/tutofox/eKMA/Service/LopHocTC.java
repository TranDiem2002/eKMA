package com.tutofox.eKMA.Service;

import com.tutofox.eKMA.Model.Request.*;

import java.util.List;

public interface LopHocTC {

    String addLopHocTC (List<LopHocTCRequest> lophoc);

    String addLopHoc(LichHocRequest lichHocRequest);

    String updateMonHoc(int monhocID, String lopHocID);

     String addSinhVien (List<LopHocTCRequest> lopHocTCRequests) ;

     String updateDiemSinhVien(List<MonDiemRequest> monDiemRequests);
}
