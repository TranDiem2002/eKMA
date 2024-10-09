package com.tutofox.eKMA.Service;

import com.tutofox.eKMA.Entity.MonHocEntity;
import com.tutofox.eKMA.Model.Request.LichHocRequest;
import com.tutofox.eKMA.Model.Request.MonHocRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonHocService  {

    int addMonhoc(LichHocRequest lichHocRequest);
}
