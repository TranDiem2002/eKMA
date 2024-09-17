package com.tutofox.eKMA.Repository;

import com.tutofox.eKMA.Entity.SinhVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SinhVienEntity, String> {

    Optional<SinhVienEntity> findByEmail (String username);

}
