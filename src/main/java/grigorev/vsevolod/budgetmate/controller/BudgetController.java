package grigorev.vsevolod.budgetmate.controller;

import grigorev.vsevolod.budgetmate.model.Expense;
import grigorev.vsevolod.budgetmate.model.Income;
import grigorev.vsevolod.budgetmate.service.BudgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/incomes")
    public List<Income> getAllIncomes() {
        return budgetService.getAllIncomes();
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return budgetService.getAllExpenses();
    }

    @PostMapping("/incomes")
    public void addIncome(@RequestBody Income income) {
        budgetService.addIncome(income);
    }

    @PostMapping("/expenses")
    public void addExpense(@RequestBody Expense expense) {
        budgetService.addExpense(expense);
    }

    @GetMapping("/balance")
    public double getBalance() {
        return budgetService.calculateBalance();
    }
}
