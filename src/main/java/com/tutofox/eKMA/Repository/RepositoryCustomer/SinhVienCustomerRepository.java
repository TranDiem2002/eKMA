package com.tutofox.eKMA.Repository.RepositoryCustomer;

import com.tutofox.eKMA.Entity.SinhVienEntity;

public interface SinhVienCustomerRepository {
    SinhVienEntity getInformationDetail(String maSV);

    SinhVienEntity searchStudents(String maSV);

}
