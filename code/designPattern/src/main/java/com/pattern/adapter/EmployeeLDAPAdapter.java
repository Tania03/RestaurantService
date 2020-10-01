package com.pattern.adapter;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class EmployeeLDAPAdapter implements Employee {

    EmployeeLDAP instance;

    public EmployeeLDAPAdapter(EmployeeLDAP employeeLDAP) {
        this.instance = employeeLDAP;
    }


    @Override
    public String getId() {
        return instance.geteId();
    }

    @Override
    public String getFirstName() {
        return instance.getGivenName();
    }

    @Override
    public String lastName() {
        return instance.getSurname();
    }

    @Override
    public String email() {
        return instance.getMail();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeLDAPAdapter{");
        sb.append("instance=").append(instance);
        sb.append('}');
        return sb.toString();
    }
}
