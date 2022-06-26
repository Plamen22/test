package com.test.test;

import java.util.List;

public class Employee {
    private int id;

    private String name;

    private int contractId;

    private double salary;

    private List<Document> documents;

    public Employee(int id, String name, int contractId, double salary, List<Document> documents) {
        this.id = id;
        this.name = name;
        this.contractId = contractId;
        this.salary = salary;
        this.documents = documents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contractId=" + contractId +
                ", salary=" + salary +
                ", documents=" + documents +
                '}';
    }
}
