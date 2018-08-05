package br.com.globalpoints.helpdesk.business.users.models;

import br.com.globalpoints.helpdesk.business.tickets.enums.ProfileEnum;

import java.util.List;
import java.util.UUID;

public class AuthenticatedUser {
    private String id;
    private UUID buId;
    private String name;
    private ProfileEnum profile;
    private List<UUID> campaignIds;

    public List<UUID> getCampaignIds() {
        return campaignIds;
    }

    public void setCampaignIds(List<UUID> campaignIds) {
        this.campaignIds = campaignIds;
    }

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
}
