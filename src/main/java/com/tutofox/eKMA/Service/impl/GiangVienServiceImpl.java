package com.tutofox.eKMA.Service.impl;

import com.tutofox.eKMA.Entity.GiangVien;
import com.tutofox.eKMA.Entity.KhoaEntity;
import com.tutofox.eKMA.Model.Request.GiangVienRequest;
import com.tutofox.eKMA.Repository.GiangVienRepository;
import com.tutofox.eKMA.Repository.RepositoryCustomer.KhoaCustomerRepository;
import com.tutofox.eKMA.Service.GiangVienService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GiangVienServiceImpl implements GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private KhoaCustomerRepository khoaRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public String addGiangVien(List<GiangVienRequest> giangVienRequests) {
        List<GiangVien> giangVienList = new ArrayList<>();
        for(GiangVienRequest giangvien: giangVienRequests){
            List<KhoaEntity> khoa = khoaRepository.findByName(giangvien.getKhoaName());
            if(khoa.isEmpty()){
                return "khoa cua giang vien " + giangvien.getHoTen() + " khong ton tai";
            }
            else {
                GiangVien giangVien = mapper.map(giangvien, GiangVien.class);
                giangVien.setKhoaID(khoa.get(0));
                giangVienList.add(giangVien);
            }
        }
        giangVienRepository.saveAll(giangVienList);
        return "add giang vien thanh cong";
    }
}
