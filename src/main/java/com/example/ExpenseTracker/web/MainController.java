package com.example.ExpenseTracker.web;

import com.example.ExpenseTracker.model.Expense;
import com.example.ExpenseTracker.model.Income;
import com.example.ExpenseTracker.model.Pie;
import com.example.ExpenseTracker.service.ExpenseService;
import com.example.ExpenseTracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    IncomeService incomeService;

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }


//    @GetMapping("/")
//    public String home()
//    {
//        return "index";
//    }

    @GetMapping("/")
    public ModelAndView home(@AuthenticationPrincipal UserDetails userDetails) {
        String usn = userDetails.getUsername();
        int totalexpense = 0;
        int totalincome = 0;
        List<Expense> expenseList = expenseService.getExpenses(usn);
        List<Income> incomeList = incomeService.getIncomes(usn);
        for (Income income:incomeList)
        {
            totalincome+=income.getAmount();
        }
        for (Expense expense:expenseList)
        {
            totalexpense+=expense.getAmount();
        }

        List<Pie> pieList = new ArrayList<Pie>();

        Pie pie1 = new Pie("Total Expense", totalexpense);
        Pie pie2 = new Pie("Total Income", totalincome);

        pieList.add(pie1);
        pieList.add(pie2);

        System.out.println(pieList);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pieList", pieList);
        return modelAndView;
    }


}
