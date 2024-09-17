package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;


    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maSV")
    public SinhVienEntity user;

    private Status status;

    @Column(name = "timeLogin")
    private Date timeLogin;

    @Column(name = "logoutTime")
    public Date logoutTime;
}
