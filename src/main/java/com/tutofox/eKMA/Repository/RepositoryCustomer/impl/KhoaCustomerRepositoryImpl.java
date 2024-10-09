package com.tutofox.eKMA.Repository.RepositoryCustomer.impl;

import com.tutofox.eKMA.Entity.KhoaEntity;
import com.tutofox.eKMA.Entity.SinhVienEntity;
import com.tutofox.eKMA.Repository.RepositoryCustomer.KhoaCustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class KhoaCustomerRepositoryImpl implements KhoaCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<KhoaEntity> findByName(String tenKhoa) {
        String sql = "select * from khoa where ten_khoa = :tenKhoa";
        Query query = entityManager.createNativeQuery(sql, KhoaEntity.class);
        query.setParameter("tenKhoa", tenKhoa);
        return query.getResultList();
    }
}
