package com.cereb.restapi.cerebai_interview;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, UUID> { 
    
}
