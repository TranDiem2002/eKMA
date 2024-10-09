package com.tutofox.eKMA.Controller;

import com.tutofox.eKMA.Model.Request.LichHocRequest;
import com.tutofox.eKMA.Model.Request.LopHocTCRequest;
import com.tutofox.eKMA.Model.Request.MonDiemRequest;
import com.tutofox.eKMA.Service.CaHocService;
import com.tutofox.eKMA.Service.LopHocTC;
import com.tutofox.eKMA.Service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class LopHocController {

    @Autowired
    private LopHocTC lopHocTC;

    @Autowired
    private MonHocService monHocService;

    @Autowired
    private CaHocService caHocService;

    @PostMapping("/lichhoc/add")
    public ResponseEntity<?> addLichhoc(@RequestBody List<LichHocRequest> lichHocRequests, @AuthenticationPrincipal UserDetails user){

       for(LichHocRequest lichHocRequest: lichHocRequests){
           String lopHocId = lopHocTC.addLopHoc(lichHocRequest);

           int monhoc = monHocService.addMonhoc(lichHocRequest);

           String addMonHoc = lopHocTC.updateMonHoc(monhoc,lopHocId);
           if(addMonHoc == "khong co lop hoc"){
               return new ResponseEntity<>(addMonHoc, HttpStatus.BAD_REQUEST);
           }
           if(addMonHoc == "add mon hoc thanh cong"){
               String addCahoc =  caHocService.addListCaHoc(lichHocRequest.getCahoc(),lichHocRequest.getLophocID());
               if(addCahoc != "add ca học thành công"){
                   return new ResponseEntity<>(addCahoc, HttpStatus.BAD_REQUEST);
               }
           }
       }
        return new ResponseEntity<>("add lich hoc thanh cong", HttpStatus.OK);
    }

    @PostMapping("/lophoctc/addsv")
    public ResponseEntity<?> addSinhVien(@RequestBody List<LopHocTCRequest> lopHocTCRequest, @AuthenticationPrincipal UserDetails user){
        String response = lopHocTC.addSinhVien(lopHocTCRequest);
        if(response != "add sinh viên vào lớp học thành công")
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/diem/add")
    public ResponseEntity<?> addDiem(@RequestBody List<MonDiemRequest> monDiemRequests, @AuthenticationPrincipal UserDetails user){
        String response = lopHocTC.updateDiemSinhVien(monDiemRequests);
        if(response != "add danh sách điểm thành công")
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
