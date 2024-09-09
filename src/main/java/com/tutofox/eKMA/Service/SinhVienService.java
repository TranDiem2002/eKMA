package com.tutofox.eKMA.Service;

import com.tutofox.eKMA.Model.Response.DiemDetailModel;
import com.tutofox.eKMA.Model.Response.DiemModel;
import com.tutofox.eKMA.Model.Response.SinhVienDetailModel;
import com.tutofox.eKMA.Model.Response.SinhVienModel;

import java.util.List;

public interface SinhVienService {

    SinhVienDetailModel getInformationStudentDetail(String maSV);

    SinhVienModel getStudentByMaSV(String sinhVien);

    List<DiemModel> getAllDiemByHK(String maSV);

    List<DiemDetailModel> getDiemDetail(String maSV, int diemId);

    List<DiemModel> getAllDiem(String maSV);


}
