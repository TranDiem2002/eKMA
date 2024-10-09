package com.tutofox.eKMA.Service.impl;

import com.tutofox.eKMA.Entity.DiemEntity;
import com.tutofox.eKMA.Entity.MonHocEntity;
import com.tutofox.eKMA.Entity.SinhVienEntity;
import com.tutofox.eKMA.Model.Response.*;
import com.tutofox.eKMA.Repository.UserRepository;
import com.tutofox.eKMA.Service.SinhVienService;
import com.tutofox.eKMA.util.SinhVienMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SinhVienServiceImpl implements SinhVienService {
    @Autowired
    private UserRepository userRepository;

    private SinhVienMapper mapper;

    public SinhVienServiceImpl() {
        this.mapper = new SinhVienMapper();
    }

    @Override
    public SinhVienDetailModel getInformationStudentDetail(String email) {
        Optional<SinhVienEntity> sinhvien = userRepository.findByEmail(email);
        if(sinhvien.isPresent()){
            return mapper.converttoSVDetaiModel(sinhvien.get());
        }
        return new SinhVienDetailModel();
    }

    @Override
    public List<SinhVienModel> getStudentByMaSV(String sinhVien) {
        List<SinhVienModel> sinhVienModels = new ArrayList<>();
        Optional<SinhVienEntity> sinhVienEntity = userRepository.findByEmail(sinhVien);
        Optional<SinhVienEntity> sinhVien1 = userRepository.findById(sinhVien);
        if(sinhVienEntity.isPresent()){
            sinhVienModels.add(new SinhVienModel(sinhVienEntity.get().getMaSV(), sinhVienEntity.get().getHoTen()));
        }
        if(sinhVien1.isPresent()){
            sinhVienModels.add(new SinhVienModel(sinhVien1.get().getMaSV(), sinhVien1.get().getHoTen()));
        }
        return sinhVienModels;
    }

    @Override
    public Double getGPA(String email) {
        SinhVienEntity sinhVien = userRepository.findByEmail(email).get();
        List<DiemEntity> diemEntities = sinhVien.getListDiem();
        Double tongDiem = 0.0;
        int tongTin = 0;
        for(DiemEntity diem: diemEntities){
            MonHocEntity monHocEntities = diem.getMonhocID();
            tongTin += monHocEntities.getSoTinChi();
            if(diem.getDiemChu().equals("A+") ) {
                tongDiem += 4.0 * monHocEntities.getSoTinChi();
                System.out.println(tongDiem);
            } else{
                if(diem.getDiemChu() .equals("A")) {
                    tongDiem += 3.8 * monHocEntities.getSoTinChi();
                }else {
                    if(diem.getDiemChu() .equals("B+") ){
                        tongDiem += 3.5 * monHocEntities.getSoTinChi();
                    }else {
                        if(diem.getDiemChu() .equals("B")) {
                            tongDiem += 3.0 * monHocEntities.getSoTinChi();
                        }else {
                            if(diem.getDiemChu() .equals("C+")) {
                                tongDiem += 2.5 * monHocEntities.getSoTinChi();
                            }else {
                                if(diem.getDiemChu() .equals("C")) {
                                    tongDiem += 2.0 * monHocEntities.getSoTinChi();
                                }else {
                                    if(diem.getDiemChu() .equals("D+")) {
                                        tongDiem += 1.5 * monHocEntities.getSoTinChi();
                                    }else {
                                        if(diem.getDiemChu() .equals("D")) {
                                            tongDiem += 1.0 * monHocEntities.getSoTinChi();
                                        }else {
                                            tongDiem += 0.0 * monHocEntities.getSoTinChi();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return Math.round((tongDiem / tongTin) * 100.0) / 100.0;
    }

    @Override
    public List<DiemNamHocModel> getAllDiemByHK(String email) {
        List<DiemNamHocModel> diemModel =new ArrayList<>();
        SinhVienEntity sinhVien = userRepository.findByEmail(email).get();
        List<DiemEntity> diemEntities = sinhVien.getListDiem();
        double diemnam1 = 0.0;
        int soTC1 = 0;
        double diemnam2 = 0.0;
        int soTC2 = 0;
        double diemnam3 = 0.0;
        int soTC3 = 0;
        double diemnam4 = 0.0;
        int soTC4 = 0;
        double diemnam5 = 0.0;
        int soTC5 = 0;
        for(DiemEntity diem: diemEntities){
            MonHocEntity monHoc = diem.getMonhocID();
            if(monHoc.getHocki() == 1 || monHoc.getHocki() == 2) {
                diemnam1 += diem.getDiemTK() * monHoc.getSoTinChi();
                soTC1 += monHoc.getSoTinChi();
            }
            if(monHoc.getHocki() == 3 || monHoc.getHocki() == 4){
                diemnam2 = diem.getDiemTK() * monHoc.getSoTinChi();
                soTC2 += monHoc.getSoTinChi();
            }
            if(monHoc.getHocki() == 5 || monHoc.getHocki() == 6) {
                diemnam3 = diem.getDiemTK() * monHoc.getSoTinChi();
                soTC3 += monHoc.getSoTinChi();
            }
            if(monHoc.getHocki() == 7 || monHoc.getHocki() == 8) {
                diemnam4 = diem.getDiemTK() * monHoc.getSoTinChi();
                soTC4 += monHoc.getSoTinChi();
            }
            if(monHoc.getHocki() == 9 || monHoc.getHocki() == 10) {
                diemnam5 = diem.getDiemTK() * monHoc.getSoTinChi();
                soTC5 += monHoc.getSoTinChi();
            }
        }

        if(soTC1 != 0){
            DiemNamHocModel diemNamHocModel = new DiemNamHocModel();
            diemNamHocModel.setNamhoc("Năm 1");
            diemNamHocModel.setDiemtb(Math.round((diemnam1/soTC1)*100.0)/100.0);
            diemModel.add(diemNamHocModel);
        }
        else {
            diemModel.add(new DiemNamHocModel("Năm 1", 0.0));
        }

        if(soTC2 != 0){
            DiemNamHocModel diemNamHocModel = new DiemNamHocModel();
            diemNamHocModel.setNamhoc("Năm 2");
            diemNamHocModel.setDiemtb(Math.round((diemnam2/soTC2)*100.0)/100.0);
            diemModel.add(diemNamHocModel);
        }
        else {
            diemModel.add(new DiemNamHocModel("Năm 2", 0.0));
        }

        if(soTC3 != 0){
            DiemNamHocModel diemNamHocModel = new DiemNamHocModel();
            diemNamHocModel.setNamhoc("Năm 3");
            diemNamHocModel.setDiemtb(Math.round((diemnam3/soTC3)*100.0)/100.0);
            diemModel.add(diemNamHocModel);
        }
        else {
            diemModel.add(new DiemNamHocModel("Năm 3", 0.0));
        }

        if(soTC4 != 0){
            DiemNamHocModel diemNamHocModel = new DiemNamHocModel();
            diemNamHocModel.setNamhoc("Năm 4");
            diemNamHocModel.setDiemtb(Math.round((diemnam4/soTC4)*100.0)/100.0);
            diemModel.add(diemNamHocModel);
        }
        else {
            diemModel.add(new DiemNamHocModel("Năm 4", 0.0));
        }

        if(soTC5 != 0){
            DiemNamHocModel diemNamHocModel = new DiemNamHocModel();
            diemNamHocModel.setNamhoc("Năm 5");
            diemNamHocModel.setDiemtb(Math.round((diemnam5/soTC5)*100.0)/100.0);
            diemModel.add(diemNamHocModel);
        }
        else {
            diemModel.add(new DiemNamHocModel("Năm 5", 0.0));
        }

        return diemModel;
    }

    @Override
    public List<DiemTungMon> getDiemDetail(String email, int namhoc) {
        List<DiemTungMon> diemTungMons = new ArrayList<>();

        SinhVienEntity sinhVien = userRepository.findByEmail(email).get();
        List<DiemEntity> diemEntities = sinhVien.getListDiem();
        for (DiemEntity diem: diemEntities){
            MonHocEntity monHoc = diem.getMonhocID();
            if(monHoc.getHocki() == namhoc*2 || monHoc.getHocki() == namhoc*2-1){
                DiemTungMon diemTungMon = new DiemTungMon();

                diemTungMon.setMonHoc(monHoc.getTenMonHoc());
                diemTungMon.setDiemTP1(diem.getDiemTP1());
                diemTungMon.setDiemTP2(diem.getDiemTP2());
                diemTungMon.setDiemTK(diem.getDiemTK());
                diemTungMon.setDiemChu(diem.getDiemChu());

                diemTungMons.add(diemTungMon);
            }
        }
        return diemTungMons;
    }

    @Override
    public List<DiemModel> getAllDiem(String maSV) {
        return null;
    }
}
