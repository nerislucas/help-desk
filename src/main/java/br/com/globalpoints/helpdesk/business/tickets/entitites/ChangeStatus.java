package br.com.globalpoints.helpdesk.business.tickets.entitites;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.globalpoints.helpdesk.business.tickets.enums.Status;
import br.com.globalpoints.helpdesk.business.users.entities.UserHelpDesk;
import br.com.globalpoints.helpdesk.business.commom.entities.EntityBase;

@Document
public class ChangeStatus extends EntityBase<String> {
    @DBRef
    @Indexed()
    private Ticket ticket;
    @DBRef
    @Indexed()
    private UserHelpDesk userHelpDeskChange;
    private UUID userChange;
    private Date dateChangeStatus;
    @Indexed()
    private Status status;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public UserHelpDesk getUserHelpDeskChange() {
        return userHelpDeskChange;
    }

    public void setUserHelpDeskChange(UserHelpDesk userHelpDeskChange) {
        this.userHelpDeskChange = userHelpDeskChange;
    }

    public UUID getUserChange() {
        return userChange;
    }

    public void setUserChange(UUID userChange) {
        this.userChange = userChange;
    }

    public Date getDateChangeStatus() {
        return dateChangeStatus;
    }

    public void setDateChangeStatus(Date dateChangeStatus) {
        this.dateChangeStatus = dateChangeStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
