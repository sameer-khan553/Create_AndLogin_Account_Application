package sameer.create_login_account.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sameer.create_login_account.DTO.LoginRequest;
import sameer.create_login_account.DTO.RegisterRequest;
import sameer.create_login_account.Entity.User;
import sameer.create_login_account.Repositry.UserRepository;

@Service
public class UserService {


    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public String register(RegisterRequest request) {

        if(repo.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));

        repo.save(user);

        return "User Registered Successfully";
    }

    public String login(LoginRequest request) {

        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(encoder.matches(request.getPassword(), user.getPassword())) {
            return "Login Successful";
        }

        return "Invalid Credentials";
    }
}
