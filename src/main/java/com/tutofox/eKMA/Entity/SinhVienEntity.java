package com.tutofox.eKMA.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sinhvienKMA")
public class SinhVienEntity implements UserDetails {

    @Id
    @Column(name = "maSV")
    private String maSV;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ngaySinh")
    private String ngaySinh;

    @ManyToOne
    @JoinColumn(name = "lopCQId")
    private LopCQEntity lopCQId;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "he")
    private String he;

    @Column(name = "truong")
    private  String truong;

    @Column(name = "email")
    private String email;

    @Column(name = "passWord")
    private String passWord;

    @ManyToMany
    @JoinTable(name = "lophoc_sinhvien",joinColumns = @JoinColumn(name = "maSV"), inverseJoinColumns = @JoinColumn(name = "lophocID"))
    private List<LopHocEntity> dslop;

    @ManyToMany
    @JoinTable(name = "diemSV", joinColumns = @JoinColumn(name = "maSV"), inverseJoinColumns = @JoinColumn(name = "diemID"))
    private List<DiemEntity> listDiem;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.getRole().name()));
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
