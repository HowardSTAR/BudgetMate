package grigorev.vsevolod.budgetmate.repository;


import grigorev.vsevolod.budgetmate.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}