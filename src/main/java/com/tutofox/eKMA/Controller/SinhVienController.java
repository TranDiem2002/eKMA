package com.tutofox.eKMA.Controller;

import com.tutofox.eKMA.Model.Request.AuthenticationRequest;
import com.tutofox.eKMA.Model.Request.RegisterRequest;
import com.tutofox.eKMA.Model.Response.*;
import com.tutofox.eKMA.Service.SinhVienService;
import com.tutofox.eKMA.Service.SinhVienServiceDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    @PostMapping("/user/detail")
    public ResponseEntity<SinhVienDetailModel> getDetailSinhVien(@AuthenticationPrincipal UserDetails user){
        return ResponseEntity.ok(sinhVienService.getInformationStudentDetail(user.getUsername()));
    }

    @PostMapping("/user/getAllDiem")
    public ResponseEntity<?> getGPA(@AuthenticationPrincipal UserDetails user){
        DiemDetailModel diemDetailModel = new DiemDetailModel();

        double gpa = sinhVienService.getGPA(user.getUsername());
        diemDetailModel.setGpa(gpa);
        if(gpa>= 3.6 && gpa <=4.0){
            diemDetailModel.setXeploai("Xuất sắc");
        }
        if(gpa>= 3.2 && gpa <=3.59){
            diemDetailModel.setXeploai("Giỏi");
        }
        if(gpa>= 2.5 && gpa <= 3.19){
            diemDetailModel.setXeploai("Khá");
        }
        if(gpa>= 2.0 && gpa <= 2.49){
            diemDetailModel.setXeploai("Trung bình");
        }

        diemDetailModel.setDiemNamHocModels(sinhVienService.getAllDiemByHK(user.getUsername()));

        return ResponseEntity.ok(diemDetailModel);
    }

    @PostMapping("/get/hockidetail")
    public ResponseEntity<?> getDetailDiem(@AuthenticationPrincipal UserDetails user, @RequestBody String namhoc){
        String numberString = namhoc.replaceAll("\\D+", "");
        int number = Integer.parseInt(numberString);

        List<DiemTungMon> diemTungMons = sinhVienService.getDiemDetail(user.getUsername(),number);
        return ResponseEntity.ok(diemTungMons);
    }

    @PostMapping("/search/{sinhvien}")
    public ResponseEntity<?> searchSV(@AuthenticationPrincipal UserDetails user, @PathVariable("sinhvien") String sinhvien){
        List<SinhVienModel> sinhVienModels = sinhVienService.getStudentByMaSV(sinhvien);
        return ResponseEntity.ok(sinhVienModels);
    }
}
