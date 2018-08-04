package br.com.globalpoints.helpdesk.business.enums;

public enum Status {
    NEW("New"),
    ASSIGNED("Assigned"),
    RESOLVED("Resolved"),
    APPROVED("Approved"),
    DISAPROVED("Disaproved"),
    CLOSED("Closed");

    private String value;

    Status(String value) {
        this.value = value;
    }

    private String getStatus(){
        return this.value;
    }
}
