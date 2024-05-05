package edu.sharif.webclass.security.JWT.Prac.security.controllers;

import edu.sharif.webclass.security.JWT.Prac.security.config.JwtService;
import edu.sharif.webclass.security.JWT.Prac.security.models.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginControllers {
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public LoginControllers(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> generateToken (@RequestBody UserCredential credential){
        //Create Credential
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(credential.userName(),credential.password());
        //Authenticate User
        Authentication authentication= authenticationManager.authenticate(authenticationToken);
        //Generate Token for Authenticated User
        String token = jwtService.getToken(authentication.getName());
        //Create and Send Response contains Token
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+token)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,"Authorization")
                .build();
    }
}
