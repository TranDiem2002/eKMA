package com.tutofox.eKMA.util;

import com.tutofox.eKMA.Entity.CahocEntity;
import com.tutofox.eKMA.Model.Request.CaHocRequest;
import org.modelmapper.ModelMapper;

public class CaHocMapper {

    private ModelMapper mapper = new ModelMapper();

    public CahocEntity convertToEntity(CaHocRequest caHocRequest){
        return  mapper.map(caHocRequest, CahocEntity.class);
    }

}
