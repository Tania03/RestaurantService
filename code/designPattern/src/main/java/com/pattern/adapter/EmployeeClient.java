package com.pattern.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class EmployeeClient {

    List<Employee> employeeList;

    public EmployeeClient() {
        employeeList = new ArrayList<>();
        employeeList.add(new EmployeeDB("123", "DBClient", "DBClientTest", "db@client.com"));

        EmployeeLDAP employeeLDAP = new EmployeeLDAP("123", "LDAPClient", "LDAPClientTets", "ldap@client.com");
        employeeList.add(new EmployeeLDAPAdapter(employeeLDAP));

        EmployeeCSV employeeCSV = new EmployeeCSV("123, CSVClient, CSVClientTest, csv@client.com");
        employeeList.add(new EmployeeCSVAdapter(employeeCSV));

    }

    List<Employee> getEmployees() {
        return employeeList;
    }
}
