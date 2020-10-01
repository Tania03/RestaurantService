package com.pattern.adapter;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class EmployeeDB implements Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;


    public EmployeeDB(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String lastName() {
        return null;
    }

    @Override
    public String email() {
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeDB{");
        sb.append("id='").append(id).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
