package security.start_security.configuration;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class GenerateSecreateKey {
    @Bean
    public String generateSecreteKey() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Tạo khóa đủ an toàn cho HS512
        System.out.println("key is: " + Encoders.BASE64.encode(key.getEncoded())); // In ra chuỗi Base64 để
        return "Complete ";
    }
}
