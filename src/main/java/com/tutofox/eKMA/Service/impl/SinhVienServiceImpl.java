package com.tutofox.eKMA.Service.impl;

import com.tutofox.eKMA.Model.Response.DiemDetailModel;
import com.tutofox.eKMA.Model.Response.DiemModel;
import com.tutofox.eKMA.Model.Response.SinhVienDetailModel;
import com.tutofox.eKMA.Model.Response.SinhVienModel;
import com.tutofox.eKMA.Service.SinhVienService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {
    @Override
    public SinhVienDetailModel getInformationStudentDetail(String maSV) {
        return null;
    }

    @Override
    public SinhVienModel getStudentByMaSV(String sinhVien) {
        return null;
    }

    @Override
    public List<DiemModel> getAllDiemByHK(String maSV) {
        return null;
    }

    @Override
    public List<DiemDetailModel> getDiemDetail(String maSV, int diemId) {
        return null;
    }

    @Override
    public List<DiemModel> getAllDiem(String maSV) {
        return null;
    }
}
