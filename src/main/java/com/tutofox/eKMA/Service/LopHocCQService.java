package com.tutofox.eKMA.Service;

import com.tutofox.eKMA.Model.Request.LopHocCQRequest;

import java.util.List;

public interface LopHocCQService {

    String addLopCQ(List<LopHocCQRequest> lopHocCQRequests);
}
