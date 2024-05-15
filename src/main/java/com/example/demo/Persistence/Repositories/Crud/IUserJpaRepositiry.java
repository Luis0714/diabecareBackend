package com.example.demo.Persistence.Repositories.Crud;

import com.example.demo.Persistence.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserJpaRepositiry extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity findUserByEmail(@Param("email") String email);
}
