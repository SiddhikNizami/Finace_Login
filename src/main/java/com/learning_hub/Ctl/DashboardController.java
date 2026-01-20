/**
 * 
 */
package com.learning_hub.Ctl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning_hub.Entity.User;
import com.learning_hub.services.TransactionService;
import com.learning_hub.services.UserService;

import jakarta.servlet.http.HttpSession;

/**
 * @author siddhik
 *
 */
@Controller
@RequestMapping("/dashboardCtl")
public class DashboardController {

	
	@Autowired
	private TransactionService transcationService;
	
	 @Autowired
	  private UserService userService;
	 
	 
	 @GetMapping("dashboard")
	    public String showDashboard(HttpSession session, Model model) {
	        Long userId = (Long) session.getAttribute("userId");
	        if (userId == null) {
	            return "redirect:/login";
	        }
	        User user = userService.findById(userId).orElse(null);
	        if (user == null) {
	            return "redirect:/login";
	        }
	        Map<String, Object> dashboardData = transcationService.getDashBoardData(userId);
	        model.addAttribute("user", user);
	        model.addAttribute("totalIncome", dashboardData.get("totalIncome"));
	        model.addAttribute("totalExpense", dashboardData.get("totalExpense"));
	        model.addAttribute("balance", dashboardData.get("balance"));
	        model.addAttribute("categoryExpenses", dashboardData.get("categoryExpenses"));
	        model.addAttribute("recentTransactions", dashboardData.get("recentTransactions"));
	        model.addAttribute("currentMonth", dashboardData.get("currentMonth"));
	        model.addAttribute("currentYear", dashboardData.get("currentYear"));
	        return "dashboard";
	    }
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
}
