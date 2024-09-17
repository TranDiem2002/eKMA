package com.tutofox.eKMA.Service.impl;

import com.tutofox.eKMA.Model.Request.KhoaRequest;
import com.tutofox.eKMA.Repository.KhoaRepository;
import com.tutofox.eKMA.Service.KhoaService;
import com.tutofox.eKMA.util.KhoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhoaServiceImpl implements KhoaService {

    @Autowired
    private KhoaRepository khoaRepository;

    private KhoaMapper khoaMapper;

    public KhoaServiceImpl(KhoaRepository khoaRepository) {
        this.khoaRepository = khoaRepository;
        this.khoaMapper = new KhoaMapper();
    }

    @Override
    public String addKhoa(KhoaRequest khoaRequest) {
        khoaRepository.save(khoaMapper.toKhoaEntity(khoaRequest));
        return "add thành công";
    }
}
