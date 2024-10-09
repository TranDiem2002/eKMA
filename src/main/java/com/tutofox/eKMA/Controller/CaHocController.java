package com.tutofox.eKMA.Controller;

import com.tutofox.eKMA.Model.Request.CaHocRequest;
import com.tutofox.eKMA.Model.Response.CaHocResponse;
import com.tutofox.eKMA.Service.CaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CaHocController {

    @Autowired
    private CaHocService caHocService;


    @PostMapping("/calendar/getAll")
    public  ResponseEntity<?> getCalendar(@AuthenticationPrincipal UserDetails user){
        List<CaHocResponse> caHocResponses = caHocService.getLichHoc(user.getUsername());
        return new ResponseEntity<>(caHocResponses, HttpStatus.OK);
    }
}
