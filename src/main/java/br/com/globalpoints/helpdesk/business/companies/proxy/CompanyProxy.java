package br.com.globalpoints.helpdesk.business.companies.proxy;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.globalpoints.helpdesk.business.companies.entities.Company;
import br.com.globalpoints.sharedkernel.api.response.ApiReturn;

@FeignClient(name = "companyProxy", url = "${api.companies}/companies")
public interface CompanyProxy {
    @GetMapping("clients/{clientId}")
    ApiReturn<Company> getClient(@PathVariable("clientId") UUID clientId);
}
