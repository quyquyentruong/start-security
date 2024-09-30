package security.start_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import security.start_security.services.authentications.AuthenService;

@RestController
@RequestMapping("/api/v1")
public class AuthenController {
    @Autowired
    private AuthenService authenService;

    @GetMapping("/create-user")
    public String createUser() {
//        authenService.createUser();
        authenService.createUser();
        return "create-user";
    }

    @GetMapping("/get-user")
    public String getUser() {
        return "11111111111";
//        authenService.createUser();
//        return authenService.login(username, "");
    }

    @PostMapping("new-login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "1111111111111111";
    }
}
