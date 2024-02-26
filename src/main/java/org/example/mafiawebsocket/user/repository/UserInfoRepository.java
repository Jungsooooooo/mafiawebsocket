package org.example.mafiawebsocket.user.repository;

import org.example.mafiawebsocket.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
    User findByUsernameAndPassword(String name, String password);
}
