package com.sam09.cryptography.referenceapp.constants;

public enum AppRole {
    ADMIN("Admin"),
    READER("Reader"),
    WRITER("Writer");
/*Currently only ADMIN will be used*/

    private String role;
    AppRole(String roleValue) {
        this.role = roleValue;
    }

    public String getRole(){
        return role;
    }
}
