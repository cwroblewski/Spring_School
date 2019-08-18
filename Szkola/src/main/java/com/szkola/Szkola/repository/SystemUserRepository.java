package com.szkola.Szkola.repository;


import com.szkola.Szkola.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUser, Long>
{
    SystemUser findByUsername(String username);
}