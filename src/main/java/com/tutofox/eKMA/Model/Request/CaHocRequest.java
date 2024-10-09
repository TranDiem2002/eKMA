package com.tutofox.eKMA.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class CaHocRequest {

    private Date startDate;

    private Date endDate;

    private Date dateStudy;
}
