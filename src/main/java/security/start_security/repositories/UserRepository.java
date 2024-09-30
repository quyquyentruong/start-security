package security.start_security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.start_security.enties.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
