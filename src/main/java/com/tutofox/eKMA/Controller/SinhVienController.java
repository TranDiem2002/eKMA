package com.tutofox.eKMA.Controller;

import com.tutofox.eKMA.Model.Request.AuthenticationRequest;
import com.tutofox.eKMA.Model.Request.RegisterRequest;
import com.tutofox.eKMA.Model.Response.AuthenticationResponse;
import com.tutofox.eKMA.Service.SinhVienService;
import com.tutofox.eKMA.Service.SinhVienServiceDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@CrossOrigin
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private SinhVienServiceDetail userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterRequest request){
        String response = userDetailsService.register(request);
        if(response != "đã add user thành công"){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication (@RequestBody AuthenticationRequest request){
        AuthenticationResponse response = userDetailsService.authentication(request);
        return ResponseEntity.ok(response);
    }

}
