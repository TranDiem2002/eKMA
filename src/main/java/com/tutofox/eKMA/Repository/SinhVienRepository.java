package com.tutofox.eKMA.Repository;

import com.tutofox.eKMA.Entity.SinhVienEntity;

public interface SinhVienRepository {
    SinhVienEntity getInformationDetail(String maSV);

    SinhVienEntity searchStudents(String maSV);

}
