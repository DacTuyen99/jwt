package com.example.demo.repository;

import com.example.demo.entity.EmailMessage;
import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendEmailRepository extends JpaRepository<EmailMessage,Integer> {

}
