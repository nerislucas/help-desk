package br.com.globalpoints.helpdesk.business.campaigns.proxy;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.globalpoints.sharedkernel.api.response.ApiReturn;
import br.com.globalpoints.helpdesk.business.campaigns.entities.Campaign;

@FeignClient(name = "campaignProxy", url = "${api.campaigns}/campaigns")
public interface CampaignProxy {
    @GetMapping()
    ApiReturn<Campaign> getById(UUID campaignId);
}
