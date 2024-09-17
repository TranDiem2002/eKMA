package com.tutofox.eKMA.Config;

import com.tutofox.eKMA.Entity.Status;
import com.tutofox.eKMA.Entity.Token;
import com.tutofox.eKMA.Repository.RepositoryCustomer.TokenCustomerRepository;
import com.tutofox.eKMA.Repository.TokenRepository;
import com.tutofox.eKMA.Service.SinhVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogoutService  implements LogoutHandler {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TokenCustomerRepository tokenCustomerRepository;

    @Autowired
    private SinhVienService sinhVienService;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return;
        }
        jwt = authHeader.substring(7);
        Token token = tokenCustomerRepository.findByToken(jwt);
        Date date = new Date();
        System.out.println(date);
        if(token !=null){
            token.setExpired(true);
            token.setRevoked(true);
            token.setLogoutTime(date);
            token.setStatus(Status.inactive);
            tokenRepository.save(token);
            SecurityContextHolder.clearContext();
        }
    }
}
