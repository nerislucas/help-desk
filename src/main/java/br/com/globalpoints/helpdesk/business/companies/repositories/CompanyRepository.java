package br.com.globalpoints.helpdesk.business.companies.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.globalpoints.helpdesk.business.companies.entities.Company;

@Repository
public class CompanyRepository {
    public Company getClient(UUID clientId) {
        var client = new Company();
        client.setId(clientId.toString());
        client.setName("GlobalPoints");
        return client;
    }
}
