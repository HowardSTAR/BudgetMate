package grigorev.vsevolod.budgetmate.service;

import grigorev.vsevolod.budgetmate.model.Expense;
import grigorev.vsevolod.budgetmate.model.Income;
import grigorev.vsevolod.budgetmate.repository.ExpenseRepository;
import grigorev.vsevolod.budgetmate.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public BudgetService(IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void addIncome(Income income) {
        incomeRepository.save(income);
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public double calculateBalance() {
        double totalIncome = incomeRepository.findAll().stream().mapToDouble(Income::getAmount).sum();
        double totalExpense = expenseRepository.findAll().stream().mapToDouble(Expense::getAmount).sum();
        return totalIncome - totalExpense;
    }
}
