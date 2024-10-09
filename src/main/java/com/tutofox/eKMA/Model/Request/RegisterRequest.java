package com.tutofox.eKMA.Model.Request;

import com.tutofox.eKMA.Entity.LopCQEntity;
import com.tutofox.eKMA.Entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String maSV;
    private String email;
    private String passWord;
    private String hoTen;
    private String gioiTinh;
    private String phone;
    private String ngaySinh;
    private String he;
    private  String truong;
}
