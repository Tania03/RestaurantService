package com.pattern.adapter;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class EmployeeLDAP {

    private String eId;
    private String surname;
    private String givenName;
    private String mail;

    public EmployeeLDAP(String eId, String surname, String givenName, String mail) {
        this.eId = eId;
        this.surname = surname;
        this.givenName = givenName;
        this.mail = mail;
    }

    public String geteId() {
        return eId;
    }

    public String getSurname() {
        return surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeLDAP{");
        sb.append("eId='").append(eId).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", givenName='").append(givenName).append('\'');
        sb.append(", mail='").append(mail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
