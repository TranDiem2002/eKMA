package com.tutofox.eKMA.Controller;

import com.tutofox.eKMA.Service.SinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequiredArgsConstructor
@CrossOrigin
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

}
