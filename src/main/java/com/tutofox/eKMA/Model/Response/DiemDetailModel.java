package com.tutofox.eKMA.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiemDetailModel {

    private double gpa;
    private String xeploai;
    private List<DiemNamHocModel> diemNamHocModels;
}
