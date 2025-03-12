package com.hoja.cnprapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.Candidat;
import com.hoja.cnprapi.models.CnprUser;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {

    @Query("SELECT c FROM Candidat c WHERE c.reference = ?1")
    Optional<Candidat> findCandidatByCodeUnique(String codeUnique);
    
    @Transactional
    @Modifying
    @Query("update Candidat set codeValide=false where reference=?1")
    int updatCodeValidity(String reference);

    @Query("SELECT c FROM Candidat c WHERE c.phone = ?1")
	Optional<Candidat> findCandidatByPhoneNumber(String phone);

}
