package com.ui.business.model;

public enum User {

    DEFAULT_USER("somemailbox42", "1z2x3c4v!");

    private String login, password, email;

    User(String login, String password) {
        this.login = login;
        this.password = password;
        this.email = login + "@gmail.com";
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
