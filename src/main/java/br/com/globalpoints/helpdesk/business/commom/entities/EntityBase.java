package br.com.globalpoints.helpdesk.business.commom.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;

public abstract class EntityBase<T> {
    @Id
    private String id;
    private Date systemDate;
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
