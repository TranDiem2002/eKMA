package com.tutofox.eKMA.Repository.RepositoryCustomer;

import com.tutofox.eKMA.Entity.KhoaEntity;

import java.util.List;
import java.util.Optional;

public interface KhoaCustomerRepository {

    List<KhoaEntity> findByName(String tenKhoa);
}
