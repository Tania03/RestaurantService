package com.pattern.adapter;

import java.util.StringTokenizer;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class EmployeeCSVAdapter implements Employee {

    EmployeeCSV instance;

    public EmployeeCSVAdapter(EmployeeCSV instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return String.valueOf(instance.getId());
    }

    @Override
    public String getFirstName() {
        return instance.getFirstname();
    }

    @Override
    public String lastName() {
        return instance.getLastname();
    }

    @Override
    public String email() {
        return instance.getEmailAddress();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeCSVAdapter{");
        sb.append("instance=").append(instance);
        sb.append('}');
        return sb.toString();
    }
}
