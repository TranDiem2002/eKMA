package com.tutofox.eKMA.Service;

import com.tutofox.eKMA.Config.JwtService;
import com.tutofox.eKMA.Entity.*;
import com.tutofox.eKMA.Model.Request.AuthenticationRequest;
import com.tutofox.eKMA.Model.Request.RegisterRequest;
import com.tutofox.eKMA.Model.Response.AuthenticationResponse;
import com.tutofox.eKMA.Repository.RepositoryCustomer.TokenCustomerRepository;
import com.tutofox.eKMA.Repository.RepositoryCustomer.SinhVienCustomerRepository;
import com.tutofox.eKMA.Repository.TokenRepository;
import com.tutofox.eKMA.Repository.UserRepository;
import com.tutofox.eKMA.util.SinhVienMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SinhVienServiceDetail {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SinhVienCustomerRepository sinhVienCustomerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TokenCustomerRepository tokenCustomerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    private SinhVienMapper sinhVienMapper;

    public SinhVienServiceDetail(SinhVienCustomerRepository sinhVienCustomerRepository) {
        this.sinhVienCustomerRepository = sinhVienCustomerRepository;
        this.sinhVienMapper = new SinhVienMapper();
    }

    public String register(RegisterRequest request) {
        Optional<SinhVienEntity> sinhVien = userRepository.findById(request.getMaSV());
        if(sinhVien.isPresent())
            return request.getMaSV() + " đã tồn tại";
        SinhVienEntity user = sinhVienMapper.converttoSinhVienEntity(request);
        user.setPassWord(passwordEncoder.encode(request.getPassWord()));
        user.setRole(Role.USER);
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return "đã add user thành công";
    }

    public List<SinhVienEntity> addSV(List<RegisterRequest> registerRequest, LopCQEntity lophoc) {
        List<SinhVienEntity> sinhVienEntities = new ArrayList<>();

        for(RegisterRequest request: registerRequest){
            SinhVienEntity user = sinhVienMapper.converttoSinhVienEntity(request);
            user.setPassWord(passwordEncoder.encode(request.getPassWord()));
            user.setRole(Role.USER);
            user.setLopCQId(lophoc);
            userRepository.save(user);
            var jwtToken = jwtService.generateToken(user);
            sinhVienEntities.add(user);
        }
        return sinhVienEntities;
    }

    public AuthenticationResponse authentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassWord()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken (SinhVienEntity user, String jwt){
        Date date = new Date();

        var token = Token.builder()
                .user(user)
                .token(jwt)
                .tokenType(TokenType.BEARER)
                .status(Status.activate)
                .timeLogin(date)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }


    private void revokeAllUserTokens(SinhVienEntity user){
        var validUserToken = tokenRepository.findAllValidTokenByUser(user.getMaSV());
        if(validUserToken.isEmpty()){
            return;
        }
        validUserToken.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserToken);
    }

}