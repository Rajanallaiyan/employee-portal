package com.socgen.employeeportal.model;

import java.util.Objects;

/**
 * Created by rajnalla on 7/19/2019.
 */
public class EmployeeKey {
    private final int id;

    public EmployeeKey(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeKey that = (EmployeeKey) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    @Override
    public String toString() {
        return "EmployeeKey{" +
                "id=" + id +
                '}';
    }
}
