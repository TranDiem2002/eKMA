package com.tutofox.eKMA.util;

import com.tutofox.eKMA.Entity.SinhVienEntity;
import com.tutofox.eKMA.Model.Request.RegisterRequest;
import com.tutofox.eKMA.Model.Response.SinhVienDetailModel;
import org.modelmapper.ModelMapper;

public class SinhVienMapper {

    ModelMapper modelMapper = new ModelMapper();



    public SinhVienEntity converttoSinhVienEntity(RegisterRequest sinhvien){
        return modelMapper.map(sinhvien, SinhVienEntity.class);
    }

    public SinhVienDetailModel converttoSVDetaiModel(SinhVienEntity sinhVien){
        SinhVienDetailModel sinhVienDetailModel = modelMapper.map(sinhVien,SinhVienDetailModel.class);
        sinhVienDetailModel.setLopCQ(sinhVien.getLopCQId().getTenLop());
        sinhVienDetailModel.setKhoa(sinhVien.getLopCQId().getKhoaID().getTenKhoa());
        return sinhVienDetailModel;
    }
}
