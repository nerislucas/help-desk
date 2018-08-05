package br.com.globalpoints.helpdesk.business.tickets.repositories;

import br.com.globalpoints.helpdesk.business.tickets.entitites.ChangeStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {
    Iterable<ChangeStatus> findByTicketId(String ticketId);
}
