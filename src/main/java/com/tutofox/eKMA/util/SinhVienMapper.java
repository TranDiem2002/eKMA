package com.tutofox.eKMA.util;

import com.tutofox.eKMA.Entity.SinhVienEntity;
import com.tutofox.eKMA.Model.Request.RegisterRequest;
import org.modelmapper.ModelMapper;

public class SinhVienMapper {

    ModelMapper modelMapper = new ModelMapper();

    public SinhVienEntity converttoSinhVienEntity(RegisterRequest sinhvien){
        return modelMapper.map(sinhvien, SinhVienEntity.class);
    }
}
