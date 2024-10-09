package com.tutofox.eKMA.Service.impl;

import com.tutofox.eKMA.Entity.KhoaEntity;
import com.tutofox.eKMA.Entity.LopCQEntity;
import com.tutofox.eKMA.Entity.SinhVienEntity;
import com.tutofox.eKMA.Model.Request.LopHocCQRequest;
import com.tutofox.eKMA.Model.Request.RegisterRequest;
import com.tutofox.eKMA.Repository.LopCQRepository;
import com.tutofox.eKMA.Repository.RepositoryCustomer.KhoaCustomerRepository;
import com.tutofox.eKMA.Repository.UserRepository;
import com.tutofox.eKMA.Service.LopHocCQService;
import com.tutofox.eKMA.Service.SinhVienServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LopHocCQServiceImpl implements LopHocCQService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KhoaCustomerRepository khoaCustomerRepository;

    @Autowired
    private SinhVienServiceDetail userDetailsService;

    @Autowired
    private LopCQRepository lopCQRepository;

    @Override
    public String addLopCQ(List<LopHocCQRequest> lopHocCQRequests) {
        for(LopHocCQRequest lopHoc: lopHocCQRequests) {
            List<KhoaEntity> khoa = khoaCustomerRepository.findByName(lopHoc.getTenKhoa());
            if(khoa.isEmpty()){
                return "không tồn tại khoa "+ lopHoc.getTenKhoa();
            }

            List<RegisterRequest> sv = lopHoc.getSinhvienKMA();
            for(RegisterRequest sinhvien : sv){
                Optional<SinhVienEntity> sinhVien = userRepository.findById(sinhvien.getMaSV());
                if(sinhVien.isPresent()){
                    return sinhvien.getMaSV() + " đã tồn tại";
                }
            }

            Optional<LopCQEntity> lopCQEntity = lopCQRepository.findById(lopHoc.getLopCQId());
            if(!lopCQEntity.isPresent()){
                LopCQEntity lopCQEntity1 = lopCQRepository.save(new LopCQEntity(lopHoc.getLopCQId(),lopHoc.getTenLop(),
                                                                 khoa.get(0),null));
                userDetailsService.addSV(sv,lopCQEntity1);
            }

            userDetailsService.addSV(sv,lopCQEntity.get());
        }
        return "add lớp học chính quy thành công";
    }
}
