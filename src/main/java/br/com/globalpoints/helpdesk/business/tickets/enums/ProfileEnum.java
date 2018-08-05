package br.com.globalpoints.helpdesk.business.tickets.enums;

public enum ProfileEnum {
    ADMIN("Admin"),
    CUSTOMER("Customer"),
    TECHNICIAN("Technician");

    private String profile;

    ProfileEnum(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return this.profile;
    }
}
