package br.com.globalpoints.helpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.globalpoints.helpdesk.business.tickets.enums.ProfileEnum;
import br.com.globalpoints.helpdesk.business.users.models.AuthenticatedUser;
import br.com.globalpoints.helpdesk.business.users.repositories.UserRepository;

@Service
public class AuthService {
    @Autowired
    private final UserRepository userRepository;

    AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthenticatedUser auth(String login, String password) {
        if (login == null || login.isEmpty())
            throw new Error("Login can not be empty");

        if (password == null || password.isEmpty())
            throw new Error("Password can not be empty");

        var userHelpDesk = this.userRepository.authUserHelpDesk(login, password);

        if (userHelpDesk == null)
            throw new Error("There was an error logging in");

        var authenticatedUser = new AuthenticatedUser();
        authenticatedUser.setBuId(userHelpDesk.getBu());
        authenticatedUser.setCampaignIds(userHelpDesk.getCampaigns());
        authenticatedUser.setId(userHelpDesk.getId());
        authenticatedUser.setName(userHelpDesk.getName());
        authenticatedUser.setProfile(ProfileEnum.ADMIN);
        return authenticatedUser;
    }
}
