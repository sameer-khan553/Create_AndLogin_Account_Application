package sameer.create_login_account.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import sameer.create_login_account.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
