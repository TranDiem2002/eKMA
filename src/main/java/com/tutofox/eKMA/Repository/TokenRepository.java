package com.tutofox.eKMA.Repository;

import com.tutofox.eKMA.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository  extends JpaRepository<Token, Integer> {

    @Query(value = """
            select t from Token t inner join SinhVienEntity u\s
            on t.user.maSV = u.maSV\s
            where u.maSV = :maSV and (t.expired = false or t.revoked = false)\s
            """)
    List<Token> findAllValidTokenByUser(String maSV);

    Optional<Token> findByToken(String token);
}