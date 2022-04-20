package com.example.ExpenseTracker.model;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "income")
@ToString
public class Income
{
    public Income(){}

    public Income(String source, Integer amount, User user) {
        this.source = source;
        this.amount = amount;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private Integer amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
