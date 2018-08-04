package br.com.globalpoints.helpdesk.business.models;

import br.com.globalpoints.helpdesk.business.enums.ProfileEnum;

import java.util.UUID;

public class AuthenticatedUser {
    private String id;
    private UUID buId;
    private UUID campaingId;
    private String name;
    private ProfileEnum profile;

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }

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

    public UUID getBuId() {
        return buId;
    }

    public void setBuId(UUID buId) {
        this.buId = buId;
    }

    public UUID getCampaingId() {
        return campaingId;
    }

    public void setCampaingId(UUID campaingId) {
        this.campaingId = campaingId;
    }
}
