package grigorev.vsevolod.budgetmate.repository;

import grigorev.vsevolod.budgetmate.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}

