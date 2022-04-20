package com.example.ExpenseTracker.model;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "expense")
@ToString
public class Expense
{
    public Expense(){}

    public Expense(String item, Integer amount, User user) {
        this.item = item;
        this.amount = amount;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private Integer amount;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
