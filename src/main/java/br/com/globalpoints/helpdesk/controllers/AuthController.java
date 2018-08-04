package br.com.globalpoints.helpdesk.controllers;

import br.com.globalpoints.helpdesk.business.enums.ProfileEnum;
import br.com.globalpoints.helpdesk.business.models.AuthenticatedUser;
import br.com.globalpoints.helpdesk.configurations.secutiry.providers.JwtTokenProvider;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class AuthController {
    @Inject
    private JwtTokenProvider provider;

    @GetMapping("verify")
    public String veryToken() {
        return "Error";
    }

    @PostMapping("login/authenticate")
    public String authenticate(String user, String password) {
        var authenticatedUser = new AuthenticatedUser();
        var buId = UUID.fromString("fabcf182-fd27-4d0a-b177-f0396dc1c923");
        var campaingId = UUID.fromString("52d627e4-11f2-4369-8c7d-8631069b5b75");
        System.out.println("chegou aqui");
        authenticatedUser.setBuId(buId);
        authenticatedUser.setCampaingId(campaingId);
        authenticatedUser.setId("asdadsa");
        authenticatedUser.setName("Lucas");
        authenticatedUser.setProfile(ProfileEnum.ADMIN);

        return this.provider.createToken(authenticatedUser);
    }
}
