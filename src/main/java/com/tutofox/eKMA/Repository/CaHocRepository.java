package com.tutofox.eKMA.Repository;

import com.tutofox.eKMA.Entity.CahocEntity;

import java.util.List;

public interface CaHocRepository {

    List<CahocEntity> getAllById(int caHoc);
}
