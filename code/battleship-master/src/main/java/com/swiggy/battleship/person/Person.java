package com.swiggy.battleship.person;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    public enum UserPermissions {
        ViewGame, CreateGame, PlayGame, DeleteGame, AddNewTypeGame
    }

    public enum AccountStatus {
        Created, Active, Suspended
    }


    protected String firstName;
    protected String lastName;
    protected String username;
    protected AccountStatus accountStatus; // status
    //similarly we can have age, email_address and have some validation on each fields;
    protected List<UserPermissions> permissionsList;
    protected Long createdAt;


    public Person() {
        this.permissionsList = new ArrayList<UserPermissions>();
        //add all default permissions here
        permissionsList.add(UserPermissions.ViewGame);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public List<UserPermissions> getPermissionsList() {
        return permissionsList;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
}
