package br.com.security_test.jwt_security.repository;

import br.com.security_test.jwt_security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

}
