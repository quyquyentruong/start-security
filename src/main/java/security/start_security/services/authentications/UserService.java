package security.start_security.services.authentications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.start_security.enties.CustomUserDetails;
import security.start_security.enties.User;
import security.start_security.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

//    @Override
//    public UserDetails loadUserById(Long id) {
//        // Kiểm tra xem user có tồn tại trong database không?
//        Optional<User> user = userRepository.findById(id);
//        if (user == null) {
//            throw new UsernameNotFoundException("User không tồn tại");
//        }
//        return new CustomUserDetails(user);
//    }
}
