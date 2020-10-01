package com.pattern.adapter;

import java.util.StringTokenizer;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class EmployeeCSV {

    private int id;
    private String firstname;
    private String lastname;
    private String emailAddress;

    public EmployeeCSV(String values) {

        StringTokenizer stringTokenizer = new StringTokenizer(values, ",");
        if (stringTokenizer.hasMoreElements()) {
            id = Integer.parseInt(stringTokenizer.nextToken());
        }
        if (stringTokenizer.hasMoreElements()) {
            firstname = stringTokenizer.nextToken();
        }
        if (stringTokenizer.hasMoreElements()) {
            lastname = stringTokenizer.nextToken();
        }
        if (stringTokenizer.hasMoreElements()) {
            emailAddress = stringTokenizer.nextToken();
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeCSV{");
        sb.append("id=").append(id);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
