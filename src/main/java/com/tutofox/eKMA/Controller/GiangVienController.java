package com.tutofox.eKMA.Controller;

import com.tutofox.eKMA.Model.Request.GiangVienRequest;
import com.tutofox.eKMA.Service.GiangVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin
public class GiangVienController {

    @Autowired
    private GiangVienService giangVienService;

    @PostMapping("/giangvien/add")
    public ResponseEntity<?> addGiangVien(@RequestBody List<GiangVienRequest> dsGiangVien, @AuthenticationPrincipal UserDetails user){
        String add = giangVienService.addGiangVien(dsGiangVien);
        if(add != "add giang vien thanh cong")
            return new ResponseEntity<>("khong thanh cong", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(add, HttpStatus.OK);
    }
}
