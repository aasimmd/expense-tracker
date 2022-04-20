package com.example.ExpenseTracker.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="user", uniqueConstraints=@UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private Collection<Expense> expenses;
    @OneToMany(mappedBy = "user")
    private Collection<Income> incomes;

    public User(){}

    public User(String firstName, String lastName, String email, String password, Collection<Expense> expenses, Collection<Income> incomes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.expenses = expenses;
        this.incomes = incomes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Collection<Expense> expenses) {
        this.expenses = expenses;
    }

    public Collection<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(Collection<Income> incomes) {
        this.incomes = incomes;
    }

}
