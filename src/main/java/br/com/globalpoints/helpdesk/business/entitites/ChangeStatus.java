package br.com.globalpoints.helpdesk.business.entitites;

import br.com.globalpoints.helpdesk.business.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class ChangeStatus {
    @Id
    private String id;
    @DBRef
    private Ticket ticket;
    @DBRef
    private User userChange;
    private Date dateChangeStatus;
    private Status status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUserChange() {
        return userChange;
    }

    public void setUserChange(User userChange) {
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
