package com.tutofox.eKMA.Repository;

import com.tutofox.eKMA.Entity.KhoaEntity;
import com.tutofox.eKMA.Entity.SinhVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KhoaRepository extends JpaRepository<KhoaEntity, Integer> {

}
