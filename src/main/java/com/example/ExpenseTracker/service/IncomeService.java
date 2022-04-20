package com.example.ExpenseTracker.service;

import com.example.ExpenseTracker.model.Income;
import com.example.ExpenseTracker.model.User;
import com.example.ExpenseTracker.repository.IncomeRepository;
import com.example.ExpenseTracker.repository.UserRepository;
import com.example.ExpenseTracker.web.dto.IncomeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService
{
    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    UserRepository userRepository;

    public List<Income> getIncomes(String email)
    {
        User user  = userRepository.findByEmail(email);
        return incomeRepository.findByUser(user);
    }

    public void saveIncome(IncomeDto incomeDto, String email)
    {
        User user = userRepository.findByEmail(email);
        Income income = new Income(incomeDto.getSource(), incomeDto.getAmount(), user);
        incomeRepository.save(income);
    }

    public void deleteIncome(Long id){ incomeRepository.deleteById(id); }
}
