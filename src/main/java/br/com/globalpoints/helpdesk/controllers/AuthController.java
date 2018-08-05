package br.com.globalpoints.helpdesk.controllers;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.globalpoints.helpdesk.configurations.secutiry.providers.JwtTokenProvider;
import br.com.globalpoints.helpdesk.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Inject
    private JwtTokenProvider provider;

    @Autowired
    private AuthService authService;

    @GetMapping("token/verify")
    public String veryToken() {
        return "Error";
    }

    @PostMapping("login")
    public Boolean auth(String user, String password) {
        var authenticatedUser = this.authService.auth(user, password);
        this.provider.createToken(authenticatedUser);
        return true;
    }
}
