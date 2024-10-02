package security.start_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import security.start_security.component.JwtTokenProvider;
import security.start_security.requests.LoginRequest;
import security.start_security.services.authentications.AuthenService;

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
}
