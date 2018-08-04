package br.com.globalpoints.helpdesk.business.repositories;

import br.com.globalpoints.helpdesk.business.entitites.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId);

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
            String title, String status, String priority, Pageable pages);

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
            String title, String status, String priority, Pageable pages);

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignUserOrderByDateDesc(
            String title, String status, String priority, Pageable pages);

    Page<Ticket> findByNumber(Integer number, Pageable pages);
}
