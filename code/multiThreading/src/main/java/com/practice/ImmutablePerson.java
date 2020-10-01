package com.practice;

import java.util.List;

/**
 * @author tania.gupta
 * @date 07/07/20
 */
public final class ImmutablePerson {
    final int a;
    final String name;
    final List<String> pets;

    public ImmutablePerson(int a, String name, List<String> pets) {
        this.a = a;
        this.name = name;
        this.pets = pets;
    }

    public int getA() {
        return a;
    }

    public String getName() {
        return name;
    }

    public List<String> getPets() {
        return pets;
    }
}