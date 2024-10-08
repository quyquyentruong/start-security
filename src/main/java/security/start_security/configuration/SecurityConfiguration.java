package security.start_security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/welcome/**").permitAll()  // Thay antMatchers bằng requestMatchers
                        .requestMatchers("/hello").permitAll()  // Thay antMatchers bằng requestMatchers
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
