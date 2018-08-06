package br.com.globalpoints.helpdesk.controllers;

import javax.inject.Inject;

import br.com.globalpoints.helpdesk.business.users.models.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
