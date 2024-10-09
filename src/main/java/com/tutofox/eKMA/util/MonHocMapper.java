package com.tutofox.eKMA.util;

import com.tutofox.eKMA.Entity.MonHocEntity;
import com.tutofox.eKMA.Model.Request.LichHocRequest;
import com.tutofox.eKMA.Model.Request.MonHocRequest;
import org.modelmapper.ModelMapper;

public class MonHocMapper {

    ModelMapper mapper = new ModelMapper();

    public MonHocEntity convertToEntity(MonHocRequest monHocRequest){
        return mapper.map(monHocRequest, MonHocEntity.class);
    }

    public MonHocEntity convertFromLopHocTC(LichHocRequest lichHoc){
        MonHocEntity monHoc = new MonHocEntity();
        monHoc.setHocki(lichHoc.getHocki());
        monHoc.setSoTinChi(lichHoc.getSoTinChi());
        monHoc.setTenMonHoc(lichHoc.getTenMonHoc());
        return monHoc;
    }
}
