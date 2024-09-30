package security.start_security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.start_security.enties.User;
import security.start_security.repositories.UserRepository;

@Service
public class AuthenService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createUser() {
        try {
            String username = "quyentq";
            String password = "quyentq3@3192";

            User user = new User();
//            user.setEmail(username);
//            user.setFullName("Truong Quy Quyen");
            user.setPassword(passwordEncoder.encode(password));
            user.setUsername(username);
            user.setEmail("quyentq@quyentq.com");
            userRepository.save(user);
        } catch (Exception exception) {
            return exception.getMessage();
        }

        return "";
    }

    public String login(String username, String password) {


        return "Exception";
    }
}
