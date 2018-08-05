package br.com.globalpoints.helpdesk.business.users.repositories;

import java.util.ArrayList;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import br.com.globalpoints.helpdesk.business.tickets.enums.ProfileEnum;
import br.com.globalpoints.helpdesk.business.users.entities.UserHelpDesk;
import br.com.globalpoints.sharedkernel.domain.businessunit.BusinessUnit;

@Repository
public class UserRepository {
    public UserHelpDesk authUserHelpDesk(String login, String password) {
        var userHelpDesk = new UserHelpDesk();
        var id = ObjectId.get();
        var buId = BusinessUnit.GP_BUID;
        var userId = UUID.fromString("d6d9d7f3-dd11-4909-a0a0-359125736008");
        var campaignId = UUID.fromString("52d627e4-11f2-4369-8c7d-8631069b5b75");
        var campaignsId = new ArrayList<UUID>();

        campaignsId.add(campaignId);
        userHelpDesk.setBu(buId);
        userHelpDesk.setCampaigns(campaignsId);
        userHelpDesk.setId(id.toString());
        userHelpDesk.setUser(userId);
        userHelpDesk.setProfile(ProfileEnum.ADMIN);
        return userHelpDesk;
    }
}
