package com.tutofox.eKMA.Controller;

import com.tutofox.eKMA.Model.Request.KhoaRequest;
import com.tutofox.eKMA.Repository.KhoaRepository;
import com.tutofox.eKMA.Service.KhoaService;
import com.tutofox.eKMA.util.KhoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@CrossOrigin
public class KhoaController {

    @Autowired
    private KhoaService khoaService;

    @PostMapping("/khoa/add")
    public ResponseEntity<?> addKhoa(@AuthenticationPrincipal UserDetails user,KhoaRequest khoaRequest){
        String response = khoaService.addKhoa(khoaRequest);
        if(response != "add thành công"){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }
}
