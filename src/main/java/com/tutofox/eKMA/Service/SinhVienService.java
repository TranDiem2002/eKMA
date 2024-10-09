package com.tutofox.eKMA.Service;

import com.tutofox.eKMA.Model.Response.*;

import java.util.List;

public interface SinhVienService {

    SinhVienDetailModel getInformationStudentDetail(String maSV);

    List<SinhVienModel> getStudentByMaSV(String sinhVien);

    Double getGPA(String email);

    List<DiemNamHocModel> getAllDiemByHK(String email);

    List<DiemTungMon> getDiemDetail(String email, int namhoc);

    List<DiemModel> getAllDiem(String maSV);


}
