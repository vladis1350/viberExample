package by.testbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import by.testbot.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByViberId(String id);
    List<User> findUserByRole(String role);
}
