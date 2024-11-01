package gr.krionas.TicketsTradingPlatform.controller;

import gr.krionas.TicketsTradingPlatform.model.User;
import gr.krionas.TicketsTradingPlatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // This maps to login.html in the templates folder
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // This should map to register.html in templates
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (userService.isUsernameOrEmailExists(user.getUsername(), user.getEmail())) {
            result.rejectValue("username", "error.user", "Username or Email is already taken");
            return "register";
        }

        user.setRole("USER");
        userService.saveUser(user);
        return "redirect:/login";
    }
}
