package com.example.ExpenseTracker.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDto
{
    private String source;
    private Integer amount;
}
