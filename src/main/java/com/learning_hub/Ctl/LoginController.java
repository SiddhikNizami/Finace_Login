
/**
 * 
 */
package com.learning_hub.Ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning_hub.Entity.User;
import com.learning_hub.services.UserService;

import jakarta.servlet.http.HttpSession;

/**
 * @author siddhik
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	private String Home() {
		return "login";
	}

	@GetMapping("/login")
	private String LoginRedirect() {
		return "login";
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, Model model) {
		User user = userService.ValidateLogin(username, password);
		if (user != null) {
			session.setAttribute("userId", user.getId());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("fullName", user.getFullName());
			return "redirect:/dashboardCtl/dashboard";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}

	}
	
	@PostMapping("/register")
    public String processRegistration(@RequestParam("username") String username,
                                      @RequestParam("email") String email,
                                      @RequestParam("password") String password,
                                      @RequestParam("fullName") String fullName,
                                      Model model) {
        if (userService.userNameExists(username)) {
            model.addAttribute("error", "Username already exists");
            return "login";
        }
        if (userService.emailExists(email)) {
            model.addAttribute("error", "Email already exists");
            return "login";
        }
        User user = new User(username, email, password, fullName);
        userService.UserRegistration(user);
        model.addAttribute("success", "Registration successful! Please login.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
