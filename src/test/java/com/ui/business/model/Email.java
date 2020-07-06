package com.ui.business.model;

import java.util.Objects;

public class Email implements Cloneable, Comparable<Email>{
    private String toField;
    private String subjectField;
    private String emailBody;

    public String getToField() {
        return toField;
    }

    public String getSubjectField() {
        return subjectField;
    }

    public String getEmailBody() {
        return emailBody;
    }

    private Email(Builder builder) {
        toField = builder.toField;
        subjectField = builder.subjectField;
        emailBody = builder.emailBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(toField, email.toField) &&
                Objects.equals(subjectField, email.subjectField) &&
                Objects.equals(emailBody, email.emailBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toField, subjectField, emailBody);
    }

    @Override
    public int compareTo(Email otherEmail) {
        return (this.getSubjectField().compareTo(otherEmail.getSubjectField()));
    }

    @Override
    public Email clone(){
        Email clonedEmail = null;
        try {
            clonedEmail = (Email)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedEmail;
    }

    public static final class Builder {
        private String toField;
        private String subjectField;
        private String emailBody;

        public Builder() {
        }

        public Builder toField(String val) {
            toField = val;
            return this;
        }

        public Builder subjectField(String val) {
            subjectField = val;
            return this;
        }

        public Builder emailBody(String val) {
            emailBody = val;
            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }
}
