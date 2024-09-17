package com.tutofox.eKMA.util;

import com.tutofox.eKMA.Entity.KhoaEntity;
import com.tutofox.eKMA.Model.Request.KhoaRequest;
import org.modelmapper.ModelMapper;

public class KhoaMapper {

    ModelMapper mapper = new ModelMapper();

    public KhoaEntity toKhoaEntity(KhoaRequest khoa){
        return mapper.map(khoa, KhoaEntity.class);
    }
}
