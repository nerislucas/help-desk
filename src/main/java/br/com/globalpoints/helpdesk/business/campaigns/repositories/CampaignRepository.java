package br.com.globalpoints.helpdesk.business.campaigns.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.globalpoints.helpdesk.business.campaigns.entities.Campaign;

@Repository
public class CampaignRepository {
    public Campaign getById(UUID campaignId) {
        var campaign = new Campaign();
        campaign.setId(campaignId.toString());
        campaign.setName("Campaign GlobalPoints");
        return campaign;
    }
}
