package br.com.globalpoints.helpdesk.business.entitites;

import java.util.List;
import java.util.UUID;

import br.com.globalpoints.helpdesk.business.enums.ProfileEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UsersHelpDesk")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    User(){ }

    @Id
    private String id;
    @Indexed(unique = true)
    private String login;
    private String password;
    private UUID userId;
    private List<UUID> campaignsIds;
    @Transient
    private UUID buId;
    private ProfileEnum profile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<UUID> getCampaignsIds() {
        return campaignsIds;
    }

    public void setCampaignsIds(List<UUID> campaignsIds) {
        this.campaignsIds = campaignsIds;
    }

    public UUID getBuId() {
        return buId;
    }

    public void setBuId(UUID buId) {
        this.buId = buId;
    }

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }
}
