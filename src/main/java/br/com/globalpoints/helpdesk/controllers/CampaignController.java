package br.com.globalpoints.helpdesk.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.globalpoints.helpdesk.business.campaigns.entities.Campaign;
import br.com.globalpoints.helpdesk.business.campaigns.repositories.CampaignRepository;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {
    @Autowired
    private CampaignRepository campaignRepository;

    @GetMapping("{campaignId}")
    public Campaign get(@PathVariable UUID campaignId) {
        return this.campaignRepository.getById(campaignId);
    }
}
