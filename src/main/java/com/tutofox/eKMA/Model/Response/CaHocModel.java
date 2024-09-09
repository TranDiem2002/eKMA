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
public class CaHocModel {

    private int cahoc;

    private Date startDate;

    private Date endDate;

    private Date dateStudy;
}
