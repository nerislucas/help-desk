package br.com.globalpoints.helpdesk.business.enums;

public enum Priority {
    HIGH("High"),
    NORMAL("Normal"),
    LOW("Low");

    private String value;

    Priority(String value) {
        this.value = value;
    }

    public String getPriority() {
        return this.value;
    }
}
