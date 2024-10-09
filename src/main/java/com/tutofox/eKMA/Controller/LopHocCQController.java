package com.tutofox.eKMA.Controller;

import com.tutofox.eKMA.Model.Request.LopHocCQRequest;
import com.tutofox.eKMA.Model.Request.RegisterRequest;
import com.tutofox.eKMA.Service.LopHocCQService;
import com.tutofox.eKMA.Service.SinhVienServiceDetail;
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
public class LopHocCQController {

    @Autowired
    private LopHocCQService lopHocCQService;

    @PostMapping("/lophoccq/add")
    public ResponseEntity<?> addLopCQ(@RequestBody List<LopHocCQRequest> lopCQ, @AuthenticationPrincipal UserDetails user){
        String response = lopHocCQService.addLopCQ(lopCQ);
        if(response != "add lớp học chính quy thành công")
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
