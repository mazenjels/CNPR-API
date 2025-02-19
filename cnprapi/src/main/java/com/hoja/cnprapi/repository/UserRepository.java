package com.hoja.cnprapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoja.cnprapi.models.CnprUser;

@Repository
public interface UserRepository extends JpaRepository<CnprUser, Long> {

    @Query("SELECT c FROM CnprUser c WHERE c.username = ?1")
    Optional<CnprUser> findCnprUserByUsername(String username);
    
    

}
