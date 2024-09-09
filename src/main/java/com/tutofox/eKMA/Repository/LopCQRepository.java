package com.tutofox.eKMA.Repository;

import com.tutofox.eKMA.Entity.SinhVienEntity;

import java.util.List;

public interface LopCQRepository {

    List<SinhVienEntity> dsSinhVien(String maSV);
}
