package com.example.ExpenseTracker.service;

import com.example.ExpenseTracker.model.Expense;
import com.example.ExpenseTracker.model.User;
import com.example.ExpenseTracker.repository.ExpenseRepository;
import com.example.ExpenseTracker.repository.UserRepository;
import com.example.ExpenseTracker.web.dto.ExpenseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    UserRepository userRepository;

    public List<Expense> getExpenses(String email)
    {
        User user = userRepository.findByEmail(email);

        return expenseRepository.findByUser(user);
    }

    public void saveExpense(ExpenseDto expenseDto, String email)
    {
        User user = userRepository.findByEmail(email);
        Expense expense = new Expense(expenseDto.getItem(), expenseDto.getAmount(), user);
        expenseRepository.save(expense);
    }

    public void deleteExpense(Long id)
    {
        expenseRepository.deleteById(id);
    }
}
