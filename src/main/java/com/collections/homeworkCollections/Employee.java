package com.collections.homeworkCollections;

import java.util.Objects;

public class Employee implements Comparable {
    private final String lastName;      // фамилия
    private final String firstname;     // имя
    private final int department;       // номер отдела
    private final float salary;         // зарплата
    Employee(String firstname, String lastName, int department, float salary){
        this.lastName = lastName;
        this.firstname = firstname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{<br>" +
                "\"lastName\"=\"" + lastName + "\"," +
                "<br>\"firstname\"=\"" + firstname + "\"," +
                "<br>\"departmentId\"=\"" + department + "\"," +
                "<br>\"salary\"=\"" + salary + "\"<br>" +
                "}";
    }

    @Override public boolean equals(Object employee){
        if(this == employee){
            return true;
        }
        if (employee == null || this.getClass() != employee.getClass()) {
            return false;
        }
        Employee e = (Employee) employee;
        return this.lastName.equals(e.lastName) &&
                this.firstname.equals(e.firstname);
    }

    @Override public int hashCode() {
        return Objects.hash(this.firstname, this.lastName);
    }

    public String getLastName(){
        return this.lastName;
    }
    public String getFirstName(){
        return this.firstname;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee)o;
        if(this.salary > e.getSalary()){
            return 1;
        }else if(this.salary < e.getSalary()){
            return -1;
        }
        return 0;
    }
}