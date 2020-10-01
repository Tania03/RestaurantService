package com.pattern.adapter;

import java.util.List;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class AdapterDemo {

    public static void main(String[] args) {

        EmployeeClient client = new EmployeeClient();

        List<Employee> employeeList = client.getEmployees();

        System.out.println(employeeList.toString());

    }
}
