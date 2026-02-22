package sameer.create_login_account.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sameer.create_login_account.DTO.LoginRequest;
import sameer.create_login_account.DTO.RegisterRequest;
import sameer.create_login_account.Service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    // register Mapping
    @GetMapping("/register")
    public String showRegisterPage() {

        return "register";   // must match HTML file name
    }

    @PostMapping("/register")
    public String register(RegisterRequest request) {
        service.register(request);
         return "redirect:/register";
    }

    // login mapping

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginRequest request) {
       boolean isValid = service.login(request);
       if(isValid) {
           return "redirect:/dashboard";
       }
       else {
           return "redirect:/auth/login?error=true";
       }
    }

// dashBoard Mapping
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }
}