package br.com.globalpoints.helpdesk.business.tickets.entitites;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.globalpoints.helpdesk.business.tickets.enums.Priority;
import br.com.globalpoints.helpdesk.business.tickets.enums.Status;
import br.com.globalpoints.helpdesk.business.users.entities.UserHelpDesk;
import br.com.globalpoints.helpdesk.business.commom.entities.EntityBase;

@Document(collection = "Tickets")
public class Ticket extends EntityBase<String> {
    @Indexed()
    private UUID client;
    @Indexed()
    private UUID userId;
    @Indexed()
    private String userHelpDeskId;
    private String description;
    private List<String> images;
    private UUID assignUser;
    private UserHelpDesk assignUserHelpDesk;
    private Date date;
    private String title;
    private Integer number;
    @Indexed()
    private Status status;
    @Indexed()
    private Priority priority;
    private List<ChangeStatus> changes;

    public UUID getClient() {
        return client;
    }

    public void setClient(UUID client) {
        this.client = client;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserHelpDeskId() {
        return userHelpDeskId;
    }

    public void setUserHelpDeskId(String userHelpDeskId) {
        this.userHelpDeskId = userHelpDeskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public UUID getAssignUser() {
        return assignUser;
    }

    public void setAssignUser(UUID assignUser) {
        this.assignUser = assignUser;
    }

    public UserHelpDesk getAssignUserHelpDesk() {
        return assignUserHelpDesk;
    }

    public void setAssignUserHelpDesk(UserHelpDesk assignUserHelpDesk) {
        this.assignUserHelpDesk = assignUserHelpDesk;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public List<ChangeStatus> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeStatus> changes) {
        this.changes = changes;
    }
}
