package com.tutofox.eKMA.Model.Response;

import com.tutofox.eKMA.Model.Response.CaHocModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LichHocModel {

    private String monHoc;

    private String maLopHoc;

    private List<CaHocModel> caHocModels;

}
