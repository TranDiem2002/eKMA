package com.tutofox.eKMA.Service;

import com.tutofox.eKMA.Model.Request.CaHocRequest;
import com.tutofox.eKMA.Model.Response.CaHocResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CaHocService {

    String addListCaHoc(List<CaHocRequest> cahoc, String lophocID);

    List<CaHocResponse> getLichHoc( String maSV);
}
