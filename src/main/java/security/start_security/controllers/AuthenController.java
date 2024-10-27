package security.start_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import security.start_security.component.JwtTokenProvider;
import security.start_security.enties.CustomUserDetails;
import security.start_security.requests.LoginRequest;
import security.start_security.responses.LoginResponse;
import security.start_security.services.authentications.AuthenService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AuthenController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenService authenService;

    @GetMapping("/create-user")
    public String createUser() {
        authenService.createUser();
        return "create-user";
    }

    @GetMapping("/get-user")
    public String getUser(@RequestParam String username) {
        return "11111111111";
    }

    @PostMapping("new-login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "1111111111111111";
    }

    @PostMapping("/test-post")
    public String testPost(@RequestBody LoginRequest loginRequest) {

        authenService.createUser();
        //return authenService.login(username, "");
        return "11111111111";
    }

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
}
