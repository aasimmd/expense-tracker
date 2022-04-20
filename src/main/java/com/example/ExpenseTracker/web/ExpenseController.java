package com.example.ExpenseTracker.web;

import com.example.ExpenseTracker.model.Expense;
import com.example.ExpenseTracker.service.ExpenseService;
import com.example.ExpenseTracker.web.dto.ExpenseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expenses")
    public ModelAndView expenses(@AuthenticationPrincipal UserDetails userDetails) {
        String usn = userDetails.getUsername();
        List<Expense> expenseList = expenseService.getExpenses(usn);
        System.out.println(expenseList);

        ModelAndView modelAndView = new ModelAndView("expenses");
        modelAndView.addObject("expenseList", expenseList);
        return modelAndView;
    }

    @GetMapping("/addexpense")
    public ModelAndView addExpensePage(){
        return new ModelAndView("addexpense");
    }


    @ModelAttribute("expense")
    public ExpenseDto expenseDto() {
        return new ExpenseDto();
    }

    @PostMapping(path = "/addexpense", consumes = "application/x-www-form-urlencoded")
    public ModelAndView addExpense(@ModelAttribute("expense") ExpenseDto expenseDto, @AuthenticationPrincipal UserDetails userDetails) {
        String usn = userDetails.getUsername();

        expenseService.saveExpense(expenseDto, usn);
        return new ModelAndView("redirect:/expenses");
    }

    @GetMapping("/delete/expense/{id}")
    public ModelAndView deleteExpensebyId(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return new ModelAndView("redirect:/expenses");
    }
}
