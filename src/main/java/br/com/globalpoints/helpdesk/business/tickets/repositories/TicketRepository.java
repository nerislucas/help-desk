package br.com.globalpoints.helpdesk.business.tickets.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.globalpoints.helpdesk.business.tickets.entitites.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    Page<Ticket> findByUserId(Pageable pages, String userId);
}
