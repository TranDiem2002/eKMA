package com.tutofox.eKMA.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiangVienRequest {
    private String maGV;

    private String hoTen;

    private String gioiTinh;

    private String khoaName;
}
