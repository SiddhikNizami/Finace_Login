package com.learning_hub.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning_hub.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
	List<Transaction> findByUserIdOrderByTransactionDateAsc(Long userId);
	
	 List<Transaction> findByUserIdAndTransactionDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
	 @org.springframework.data.jpa.repository.Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.id = :userId " +
	           "AND t.type = 'INCOME' AND t.transactionDate BETWEEN :startDate AND :endDate")
	    Double getTotalIncome(@org.springframework.data.repository.query.Param("userId") Long userId,
	                          @org.springframework.data.repository.query.Param("startDate") LocalDate startDate,
	                          @org.springframework.data.repository.query.Param("endDate") LocalDate endDate);

	    @org.springframework.data.jpa.repository.Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.id = :userId " +
	           "AND t.type = 'EXPENSE' AND t.transactionDate BETWEEN :startDate AND :endDate")
	    Double getTotalExpense(@org.springframework.data.repository.query.Param("userId") Long userId,
	                           @org.springframework.data.repository.query.Param("startDate") LocalDate startDate,
	                           @org.springframework.data.repository.query.Param("endDate") LocalDate endDate);

	    @org.springframework.data.jpa.repository.Query("SELECT c.name, c.color, SUM(t.amount) FROM Transaction t " +
	           "JOIN t.category c WHERE t.user.id = :userId AND t.type = 'EXPENSE' " +
	           "AND t.transactionDate BETWEEN :startDate AND :endDate " +
	           "GROUP BY c.name, c.color ORDER BY SUM(t.amount) DESC")
	    List<Object[]> getCategoryWiseExpenses(@org.springframework.data.repository.query.Param("userId") Long userId,
	                                           @org.springframework.data.repository.query.Param("startDate") LocalDate startDate,
	                                           @org.springframework.data.repository.query.Param("endDate") LocalDate endDate);

}
