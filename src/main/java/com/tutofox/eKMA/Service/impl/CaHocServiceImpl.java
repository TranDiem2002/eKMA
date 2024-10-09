package com.tutofox.eKMA.Service.impl;

import com.tutofox.eKMA.Entity.CahocEntity;
import com.tutofox.eKMA.Entity.LopHocEntity;
import com.tutofox.eKMA.Entity.SinhVienEntity;
import com.tutofox.eKMA.Entity.StatusStudy;
import com.tutofox.eKMA.Model.Request.CaHocRequest;
import com.tutofox.eKMA.Model.Response.CaHocResponse;
import com.tutofox.eKMA.Repository.CaHocRepository;
import com.tutofox.eKMA.Repository.LopHocRepository;
import com.tutofox.eKMA.Repository.UserRepository;
import com.tutofox.eKMA.Service.CaHocService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CaHocServiceImpl implements CaHocService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CaHocRepository caHocRepository;

    @Autowired
    private LopHocRepository lopHocRepository;

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public String addListCaHoc(List<CaHocRequest> cahoc, String lophocID) {
        Optional<LopHocEntity> lopHoc = lopHocRepository.findById(lophocID);
        List<CahocEntity> cahocEntities = new ArrayList<>();
        for(CaHocRequest ca : cahoc){
            cahocEntities.add(modelMapper.map(ca,CahocEntity.class));
        }
        List<CahocEntity> cahocEntities1=  caHocRepository.saveAll(cahocEntities);

        List<CahocEntity> lopHocEntities = lopHoc.get().getCahoc();
        lopHocEntities.addAll(cahocEntities1);
        lopHoc.get().setCahoc(lopHocEntities);
        lopHocRepository.save(lopHoc.get());
        return "add ca học thành công";
    }

    @Override
    public List<CaHocResponse> getLichHoc(String email) {
        List<CaHocResponse> caHocResponses = new ArrayList<>();

        SinhVienEntity sinhVien = userRepository.findByEmail(email).get();

        List<LopHocEntity> lopHocEntities = sinhVien.getDslop();
        for(LopHocEntity lopHoc: lopHocEntities){
            if(lopHoc.getStatusStudy() == StatusStudy.Studed){
                lopHocEntities.remove(lopHoc);
            }
            else {
                List<CahocEntity> cahocEntities = lopHoc.getCahoc();
                cahocEntities.sort(Comparator.comparing(CahocEntity :: getStartDate));
                for(CahocEntity cahoc: cahocEntities){
                    CaHocResponse caHocResponse = new CaHocResponse();
                    caHocResponse.setMaLopHoc(lopHoc.getLophocID());
                    caHocResponse.setMonHoc(lopHoc.getMonhocID().getTenMonHoc());
                    caHocResponse.setDateStudy(formatYear(cahoc.getDateStudy()));
                    caHocResponse.setStartDate(cahoc.getStartDate());
                    caHocResponse.setEndDate(cahoc.getEndDate());

                    System.out.println(convertToUTC(cahoc.getStartDate()));
                    caHocResponses.add(caHocResponse);
                }
            }
        }
        return caHocResponses;
    }

    public static String formatDateTime(Date date) {
        SimpleDateFormat outputFormatter = new SimpleDateFormat("h:mm");
        outputFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return outputFormatter.format(date);
    }

    public static String formatYear(Date date) {
        SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
        return outputFormatter.format(date);
    }

    public static String convertToUTC(Date date) {
        // Định dạng UTC
        SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        outputFormatter.setTimeZone(TimeZone.getTimeZone("UTC")); // Đặt múi giờ UTC
        outputFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        return outputFormatter.format(date);
    }
}
