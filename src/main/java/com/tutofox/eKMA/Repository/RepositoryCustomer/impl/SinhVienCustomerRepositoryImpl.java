package com.tutofox.eKMA.Repository.RepositoryCustomer.impl;

import com.tutofox.eKMA.Entity.SinhVienEntity;
import com.tutofox.eKMA.Repository.RepositoryCustomer.SinhVienCustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SinhVienCustomerRepositoryImpl implements SinhVienCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public SinhVienEntity getInformationDetail(String email) {
        StringBuilder sql = new StringBuilder("select * from sinhvienKMA where email = '"+ email +"'");
        Query query = entityManager.createNativeQuery(sql.toString(), SinhVienEntity.class);
        return null;
    }

    @Override
    public SinhVienEntity searchStudents(String maSV) {
        return null;
    }

}
