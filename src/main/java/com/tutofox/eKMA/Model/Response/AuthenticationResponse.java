package com.tutofox.eKMA.Model.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class AuthenticationResponse {

    private String token;
}
