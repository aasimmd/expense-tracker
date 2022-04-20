package com.example.ExpenseTracker.web;

import com.example.ExpenseTracker.model.Income;
import com.example.ExpenseTracker.service.IncomeService;
import com.example.ExpenseTracker.web.dto.IncomeDto;
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
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @GetMapping("/incomes")
    public ModelAndView incomes(@AuthenticationPrincipal UserDetails userDetails)
    {
        String usn = userDetails.getUsername();
        List<Income> incomeList = incomeService.getIncomes(usn);
        System.out.println(incomeList);

        ModelAndView modelAndView = new ModelAndView("incomes");
        modelAndView.addObject("incomeList", incomeList);
        return modelAndView;
    }

    @GetMapping("/addincome")
    public ModelAndView addIncomePage()
    {
        return new ModelAndView("addincome");
    }

    @ModelAttribute("income")
    public IncomeDto incomeDto() { return new IncomeDto(); }

    @PostMapping(path="/addincome", consumes = "application/x-www-form-urlencoded")
    public ModelAndView addIncome(@ModelAttribute("income") IncomeDto incomeDto, @AuthenticationPrincipal UserDetails userDetails)
    {
        String usn = userDetails.getUsername();

        incomeService.saveIncome(incomeDto, usn);
        return new ModelAndView("redirect:/incomes");
    }

    @GetMapping("/delete/income/{id}")
    public ModelAndView deleteIncomebyId(@PathVariable Long id)
    {
        incomeService.deleteIncome(id);
        return new ModelAndView("redirect:/incomes");
    }
}
