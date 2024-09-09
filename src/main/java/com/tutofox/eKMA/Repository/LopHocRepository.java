package com.tutofox.eKMA.Repository;

import com.tutofox.eKMA.Entity.LopHocEntity;

import java.util.List;

public interface LopHocRepository {

    List<LopHocEntity> getAllByMaSV(String maSV);


}
