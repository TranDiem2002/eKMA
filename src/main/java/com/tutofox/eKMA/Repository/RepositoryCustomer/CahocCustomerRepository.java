package com.tutofox.eKMA.Repository.RepositoryCustomer;

import com.tutofox.eKMA.Model.Response.CaHocResponse;

import java.util.List;

public interface CahocCustomerRepository {

    List<CaHocResponse> getCaHoc(String maSV);
}
