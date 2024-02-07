package org.example.mafiawebsocket.user.repository;

import org.example.mafiawebsocket.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByName(String name);

    UserInfo findByNameAndPassword(String name, String password);
}
