package com.tutofox.eKMA.Service;

import com.tutofox.eKMA.Entity.GiangVien;
import com.tutofox.eKMA.Model.Request.GiangVienRequest;

import java.util.List;

public interface GiangVienService {

    String addGiangVien(List<GiangVienRequest> giangVienRequests);
}
