package com.tutofox.eKMA.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CaHocResponse {

    private String monHoc;

    private String maLopHoc;

    private Date startDate;

    private Date endDate;

    private String dateStudy;
}
