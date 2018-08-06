package br.com.globalpoints.helpdesk.services;

import br.com.globalpoints.helpdesk.business.users.models.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import br.com.globalpoints.helpdesk.business.tickets.enums.ProfileEnum;
import br.com.globalpoints.helpdesk.business.users.models.AuthenticatedUser;
import br.com.globalpoints.helpdesk.business.users.repositories.UserRepository;

import java.util.Collections;

@Service
public class AuthService implements AuthenticationProvider {
    private final UserRepository userRepository;

    @Autowired
    AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var user = (String) authentication.getPrincipal();
        var password = (String) authentication.getCredentials();

        if (user == null || user.isEmpty())
            throw new Error("Login can not be empty");

        if (password == null || password.isEmpty())
            throw new Error("Password can not be empty");

        var userHelpDesk = this.userRepository.authUserHelpDesk(user, password);
        if (userHelpDesk == null)
            throw new Error("There was an error logging in");

        var authenticatedUser = new AuthenticatedUser();
        authenticatedUser.setBuId(userHelpDesk.getBu());
        authenticatedUser.setCampaignIds(userHelpDesk.getCampaigns());
        authenticatedUser.setId(userHelpDesk.getId());
        authenticatedUser.setName(userHelpDesk.getName());
        authenticatedUser.setProfile(ProfileEnum.ADMIN);

        return this.createAuthenticationFor(authentication, authenticatedUser);

    }

    private UsernamePasswordAuthenticationToken createAuthenticationFor(Authentication authentication, AuthenticatedUser authenticatedUser) {
        return new UsernamePasswordAuthenticationToken(authenticatedUser, authentication.getPrincipal(), Collections.<GrantedAuthority>emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
