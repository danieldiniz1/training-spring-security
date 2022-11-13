package br.com.training.springsecurity.repository;

import br.com.training.springsecurity.model.User;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email) throws RuntimeException;
}
