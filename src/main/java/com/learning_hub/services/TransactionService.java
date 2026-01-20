package com.learning_hub.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning_hub.Entity.Transaction;
import com.learning_hub.Repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepo;

	public Transaction saveTransacation(Transaction transcation) {
		return transactionRepo.save(transcation);

	}

	public List<Transaction> getAllTranscationByUser(Long transactionId) {

		return transactionRepo.findByUserIdOrderByTransactionDateAsc(transactionId);

	}

	public Optional<Transaction> getTransactionById(Long findById) {

		return transactionRepo.findById(findById);
	}

	public void deleteTransaction(Long id) {
		transactionRepo.deleteById(id);
	}

	public Transaction updateTranacation(Transaction transaction) {
		return transactionRepo.save(transaction);
	}

	public List<Transaction> getTransactionsByDateRange(Long userId, LocalDate startDate, LocalDate endDate) {

		return transactionRepo.findByUserIdAndTransactionDateBetween(userId, startDate, endDate);
	}

	public Map<String, Object> getDashBoardData(Long userID) {

		Map<String, Object> dashBoard = new HashMap<>();
		LocalDate now = LocalDate.now();
		LocalDate startOfMonth = now.withDayOfMonth(1);
		LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());

		Double totalIncom = transactionRepo.getTotalIncome(userID, startOfMonth, endOfMonth);
		if (totalIncom == null) {
			totalIncom = 0.0;
		}
		Double totalExpense = transactionRepo.getTotalExpense(userID, startOfMonth, endOfMonth);

		if (totalExpense == null) {
			totalExpense = 0.0;

		}

		Double balance = totalIncom - totalExpense;
		
		List<Object[]> categoryExpenses = transactionRepo.getCategoryWiseExpenses(userID, startOfMonth, endOfMonth);

		List<Transaction> recentTransaction = transactionRepo.findByUserIdAndTransactionDateBetween(userID,
		startOfMonth, endOfMonth);
		dashBoard.put("totalIncome", totalIncom);
		dashBoard.put("totalExpense", totalExpense);
		dashBoard.put("balance", balance);
		dashBoard.put("categoryExpenses", categoryExpenses);
		dashBoard.put("recentTransactions", recentTransaction);
		dashBoard.put("currentMonth", now.getMonth().toString());
		dashBoard.put("currentYear", now.getYear());

		return dashBoard;

	}
}
