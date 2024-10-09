package com.tutofox.eKMA.Service.impl;

import com.tutofox.eKMA.Entity.*;
import com.tutofox.eKMA.Model.Request.*;
import com.tutofox.eKMA.Repository.*;
import com.tutofox.eKMA.Service.LopHocTC;
import com.tutofox.eKMA.util.CaHocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LopHocTCImpl implements LopHocTC {

    @Autowired
    private LopHocRepository lopHocRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MonHocRepository monHocRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private DiemRespository diemRespository;

    private CaHocMapper caHocMapper;

    public LopHocTCImpl() {
        this.caHocMapper = new CaHocMapper();
    }

    @Override
    public String addLopHocTC(List<LopHocTCRequest> lophoc) {

        return null;
    }

    @Override
    public String addLopHoc(LichHocRequest lichHocRequest) {
        Optional<GiangVien> giangVien = giangVienRepository.findById(lichHocRequest.getMaGGV());
        if(!giangVien.isPresent()){
            return "khong ton tai giang vien";
        }
        LopHocEntity lopHocEntity = new LopHocEntity();
        lopHocEntity.setLophocID(lichHocRequest.getLophocID());
        lopHocEntity.setMaGV(giangVien.get());
        lopHocEntity.setStatusStudy(StatusStudy.Studing);
        LopHocEntity lopHoc = lopHocRepository.save(lopHocEntity);
        return lopHoc.getLophocID();
    }

    @Override
    public String updateMonHoc(int monhocID, String lopHocID) {
       Optional<LopHocEntity> lopHocEntity = lopHocRepository.findById(lopHocID);
       if(!lopHocEntity.isPresent()){
           return "khong co lop hoc";
       }
       LopHocEntity lopHoc = lopHocEntity.get();
       Optional<MonHocEntity> monHoc = monHocRepository.findById(monhocID);
       lopHoc.setMonhocID(monHoc.get());
       lopHocRepository.save(lopHoc);
       return "add mon hoc thanh cong";
    }

    @Override
    public String addSinhVien(List<LopHocTCRequest> lopHocTCRequests) {
        for(LopHocTCRequest request: lopHocTCRequests) {
            Optional<LopHocEntity> lopHoc = lopHocRepository.findById(request.getLophocID());
            if (!lopHoc.isPresent()) {
                return "không tồn tại lớp học " + request.getLophocID();
            }

            for (SinhVienRequest sinhVienRequest : request.getSinhVienRequests()) {
                Optional<SinhVienEntity> sinhVien = userRepository.findById(sinhVienRequest.getMaSV());
                if (!sinhVien.isPresent()) {
                    return " không tồn tại sinh viên " + sinhVienRequest.getMaSV() + " : " + sinhVienRequest.getHoTen();
                }
            }

            for (SinhVienRequest sinhVienRequest : request.getSinhVienRequests()) {
                Optional<SinhVienEntity> sinhVien = userRepository.findById(sinhVienRequest.getMaSV());
                List<LopHocEntity> lopHocEntities = sinhVien.get().getDslop();
                lopHocEntities.add(lopHoc.get());
                sinhVien.get().setDslop(lopHocEntities);
                userRepository.save(sinhVien.get());
            }
        }
        return "add sinh viên vào lớp học thành công";
    }

    @Override
    public String updateDiemSinhVien(List<MonDiemRequest> monDiemRequests) {
        for(MonDiemRequest request : monDiemRequests){
            Optional<MonHocEntity> monHoc = monHocRepository.findById(request.getMonhocID());

            if(!monHoc.isPresent()){
                return "môn học không tồn tại";
            }

            List<SinhVienDiemRequest> sinhVienDiemRequests = request.getSinhVienDiemRequests();

            for(SinhVienDiemRequest sv : sinhVienDiemRequests){
                Optional<SinhVienEntity> sinhVien = userRepository.findById(sv.getMaSV());
                if(!sinhVien.isPresent())
                    return "sinh viên "+ sv.getMaSV() + " không tồn tại";
            }

            for(SinhVienDiemRequest sv : sinhVienDiemRequests){
                DiemEntity diem = new DiemEntity();
                diem.setMonhocID(monHoc.get());
                diem.setDiemTP1(sv.getDiemTP1());
                diem.setDiemTP2(sv.getDiemTP2());
                diem.setDiemKT(sv.getDiemKT());

                double diemTK = sv.getDiemTP1()*0.09 + diem.getDiemTP2()*0.21 + sv.getDiemKT()*0.7;
                diemTK = Math.round(diemTK * 10.0) / 10.0;
                diem.setDiemTK(diemTK);

                if(diem.getDiemTK() <= 3.9) {
                    diem.setDiemChu("F");
                } else{
                    if(diem.getDiemTK() <= 4.7) {
                        diem.setDiemChu("D");
                    }else {
                        if(diem.getDiemTK() <= 5.4) {
                            diem.setDiemChu("D+");
                        }else {
                            if(diem.getDiemTK() <= 6.2) {
                                diem.setDiemChu("C");
                            }else {
                                if(diem.getDiemTK() <= 6.9) {
                                    diem.setDiemChu("C+");
                                }else {
                                    if(diem.getDiemTK() <= 7.7) {
                                        diem.setDiemChu("B");
                                    }else {
                                        if(diem.getDiemTK() <= 8.4) {
                                            diem.setDiemChu("B+");
                                        }else {
                                            if(diem.getDiemTK() <= 8.9) {
                                                diem.setDiemChu("A");
                                            }else {
                                                diem.setDiemChu("A+");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                DiemEntity diemEntity = diemRespository.save(diem);
                Optional<SinhVienEntity> sinhVien = userRepository.findById(sv.getMaSV());
                List<DiemEntity> diemEntities = sinhVien.get().getListDiem();
                diemEntities.add(diemEntity);
                sinhVien.get().setListDiem(diemEntities);
                userRepository.save(sinhVien.get());
            }
        }
        return "add danh sách điểm thành công";
    }

    public String updateLichHoc(String lophocID, List<CaHocRequest> caHocRequests) {
        List<CahocEntity> cahocEntities = new ArrayList<>();
        for(CaHocRequest ca : caHocRequests){
            cahocEntities.add(caHocMapper.convertToEntity(ca));
        }

        Optional<LopHocEntity> lopHocEntity = lopHocRepository.findById(lophocID);
        if(!lopHocEntity.isPresent()){
            return "khong co lop hoc";
        }
        LopHocEntity lopHoc = lopHocEntity.get();
        lopHoc.setCahoc(cahocEntities);
        lopHocRepository.save(lopHoc);
        return "add ca hoc thanh cong";
    }
}
