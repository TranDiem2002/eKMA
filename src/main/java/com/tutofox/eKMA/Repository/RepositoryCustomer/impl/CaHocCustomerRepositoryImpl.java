package com.tutofox.eKMA.Repository.RepositoryCustomer.impl;

import com.tutofox.eKMA.Entity.KhoaEntity;
import com.tutofox.eKMA.Model.Response.CaHocResponse;
import com.tutofox.eKMA.Repository.RepositoryCustomer.CahocCustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CaHocCustomerRepositoryImpl implements CahocCustomerRepository {



    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<CaHocResponse> getCaHoc(String maSV) {
//        Query query = entityManager.createNativeQuery(getCalendar.toString());
//        query.setParameter("maSV",maSV);
//        return query.getResultList();
        return null;
    }
}
