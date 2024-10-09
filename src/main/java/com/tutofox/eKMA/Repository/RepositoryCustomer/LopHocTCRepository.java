package com.tutofox.eKMA.Repository.RepositoryCustomer;

import com.tutofox.eKMA.Entity.LopHocEntity;

import java.util.List;

public interface LopHocTCRepository {

    List<LopHocEntity> getAllByMaSV(String maSV);

    String addLopHocTC(LopHocEntity lopHoc);

}
