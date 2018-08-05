package br.com.globalpoints.helpdesk.business.users.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.Transient;

import br.com.globalpoints.helpdesk.business.tickets.enums.ProfileEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserHelpDesk {
    private String id;
    private UUID user;
    private List<UUID> campaigns;
    @Transient
    private UUID bu;
    private ProfileEnum profile;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public List<UUID> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<UUID> campaigns) {
        this.campaigns = campaigns;
    }

    public UUID getBu() {
        return bu;
    }

    public void setBu(UUID bu) {
        this.bu = bu;
    }

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }
}
