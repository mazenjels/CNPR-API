package com.hoja.cnprapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.Candidat;
import com.hoja.cnprapi.models.CandidatSubscription;
import com.hoja.cnprapi.models.CnprUser;

@Repository
public interface CandidatSubscriptionRepository extends JpaRepository<CandidatSubscription, Long> {

    @Query("SELECT c FROM CandidatSubscription c WHERE c.candidat.id = ?1")
    Optional<CandidatSubscription> findCandidatSubscriptionByCandidatId(long id);
    
//    @Transactional
//    @Modifying
//    @Query("update Candidat set codeValide=false where reference=?1")
//    int updatCodeValidity(String reference);
//
//    @Query("SELECT c FROM Candidat c WHERE c.phone = ?1")
//	Optional<Candidat> findCandidatByPhoneNumber(String phone);

}
