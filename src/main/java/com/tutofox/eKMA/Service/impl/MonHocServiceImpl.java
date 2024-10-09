package com.tutofox.eKMA.Service.impl;

import com.tutofox.eKMA.Entity.MonHocEntity;
import com.tutofox.eKMA.Model.Request.LichHocRequest;
import com.tutofox.eKMA.Model.Request.MonHocRequest;
import com.tutofox.eKMA.Repository.MonHocRepository;
import com.tutofox.eKMA.Service.MonHocService;
import com.tutofox.eKMA.util.MonHocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonHocServiceImpl implements MonHocService {

    @Autowired
    private MonHocRepository monHocRepository;

    private MonHocMapper mapper;

    public MonHocServiceImpl() {
        this.mapper =  new MonHocMapper();
    }

    @Override
    public int addMonhoc(LichHocRequest lichHocRequest) {
        MonHocEntity monHoc = mapper.convertFromLopHocTC(lichHocRequest);
         monHocRepository.save(monHoc);
        return monHoc.getMonhocID();
    }
}
