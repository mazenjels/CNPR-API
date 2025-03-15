package com.hoja.cnprapi.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.CnprQuestion;
import com.hoja.cnprapi.models.CnprUserAnswer;
import com.hoja.cnprapi.dto.QuestionDTO;
import com.hoja.cnprapi.dto.QuestionReponseDTO;
import com.hoja.cnprapi.models.Candidat;
import com.hoja.cnprapi.models.CandidatSubscription;
import com.hoja.cnprapi.models.CnprAutoEcole;
import com.hoja.cnprapi.repository.CandidatRepository;
import com.hoja.cnprapi.repository.CandidatSubscriptionRepository;
import com.hoja.cnprapi.repository.CnprUserAnswerRepository;
import com.hoja.cnprapi.repository.QuestionRepository;
import com.hoja.cnprapi.repository.UserRepository;

@Service
@Transactional
public class CandidatSubscriptionServiceImpl implements CandidatSubscriptionService {

	@Autowired
	CandidatSubscriptionRepository candidatSubscriptionRepository;

	@Autowired
	AutoEcoleServiceImpl autoEcoleServiceImpl;

//	public Optional<Candidat> findCandidatByCodeUnique(String codeUnique) {
//		Optional<Candidat> customerOptional = candidatRepository.findCandidatByCodeUnique(codeUnique);
////	        if (customerOptional.isPresent()) {
//////	            if (!customerOptional.get().getPassword().equals(password)) {
//////	                throw new IllegalStateException("password is not correct for email: "+ email);
//////	            }
////	        }else {
////	            throw new IllegalStateException("Identifiant: " + username + " is not present");
////	        }
//		return customerOptional;
//	}
//
//	public boolean updatCodeValidity(String codeUnique) {
//		boolean codeValidityChanged = false;
//
//		if (candidatRepository.updatCodeValidity(codeUnique) == 1) {
//			codeValidityChanged = true;
//		}
//
//		return codeValidityChanged;
//	}
//
//	@SuppressWarnings("unchecked")
//	public String getCandidat(String codeUnique) {
//
//		JSONObject jsonObj = new JSONObject();
//		new JSONObject();
//
//		try {
//			Optional<Candidat> optionalCandidat = candidatRepository.findCandidatByCodeUnique(codeUnique);
//
//			// CnprAutoEcole autoEcole = autoEcoleServiceImpl.getAutoEcoleByCandidatId();
//
////			List<Long> questionIds = new ArrayList<Long>();
////			Map<QuestionDTO, Object> mapQuestionTitles = new HashMap<QuestionDTO, Object>();
////			shuffledQuestios.forEach(q -> {
////				mapQuestionTitles.put(q, null);
////				questionIds.add(q.getId());
////			});
////			List<QuestionReponseDTO> questionReponses = getAllQuestionsResponses(questionIds);
////			List<QuestionReponseDTO> shuffledQuestionReponses = questionReponses.stream()
////		            .collect(Collectors.collectingAndThen(
////		                Collectors.toList(),
////		                collected -> {
////		                    Collections.shuffle(collected);
////		                    return collected;
////		                }
////		            ));
//////			List<QuestionReponseDTO> questionsAssertions = new ArrayList<QuestionReponseDTO>();
//////			Map<QuestionDTO, List<QuestionReponseDTO>> mapQuestion = new HashMap<QuestionDTO, List<QuestionReponseDTO>>();
////			long count=1;
//			// for (Map.Entry<QuestionDTO, Object> entry : mapQuestionTitles.entrySet()) {
//			// String qTitle = entry.getKey();
//
//			if (optionalCandidat.isPresent()) {
//				jsonObj = new JSONObject();
//				Candidat candidat = optionalCandidat.get();
//
//				jsonObj.put("id", candidat.getId());
//				jsonObj.put("nom", candidat.getNom());
//				jsonObj.put("postnom", candidat.getPostnom());
//				jsonObj.put("prenom", candidat.getPrenom());
//				jsonObj.put("phone", candidat.getPhone());
//				jsonObj.put("email", candidat.getEmail());
//				jsonObj.put("dateNaissance", candidat.getDateNaissance());
//				jsonObj.put("lieuNaissance", candidat.getLieuNaissance());
//				jsonObj.put("reference", candidat.getReference());
//				jsonObj.put("codeUniqueValide", candidat.isCodeValide());
//				jsonObj.put("typePieceIdentite", candidat.getTypePieceIdentite());
//				jsonObj.put("numeroPieceIdentite", candidat.getNumeroPieceIdentite());
//
//				return (jsonObj.toString());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return null;
//	}
//
//	@SuppressWarnings("unchecked")
//	public String getInfoCandidat(String codeUnique) {
//
//		JSONObject jsonObj = new JSONObject();
//		new JSONObject();
//
//		try {
//			Optional<Candidat> optionalCandidat = candidatRepository.findCandidatByCodeUnique(codeUnique);
//
//			// CnprAutoEcole autoEcole = autoEcoleServiceImpl.getAutoEcoleByCandidatId();
//
////			List<Long> questionIds = new ArrayList<Long>();
////			Map<QuestionDTO, Object> mapQuestionTitles = new HashMap<QuestionDTO, Object>();
////			shuffledQuestios.forEach(q -> {
////				mapQuestionTitles.put(q, null);
////				questionIds.add(q.getId());
////			});
////			List<QuestionReponseDTO> questionReponses = getAllQuestionsResponses(questionIds);
////			List<QuestionReponseDTO> shuffledQuestionReponses = questionReponses.stream()
////		            .collect(Collectors.collectingAndThen(
////		                Collectors.toList(),
////		                collected -> {
////		                    Collections.shuffle(collected);
////		                    return collected;
////		                }
////		            ));
//////			List<QuestionReponseDTO> questionsAssertions = new ArrayList<QuestionReponseDTO>();
//////			Map<QuestionDTO, List<QuestionReponseDTO>> mapQuestion = new HashMap<QuestionDTO, List<QuestionReponseDTO>>();
////			long count=1;
//			// for (Map.Entry<QuestionDTO, Object> entry : mapQuestionTitles.entrySet()) {
//			// String qTitle = entry.getKey();
//
//			JSONObject jsonCandidat = null;
//			if (optionalCandidat.isPresent()) {
//				jsonObj = new JSONObject();
//				Candidat candidat = optionalCandidat.get();
//
//				//jsonObj.put("id", candidat.getId());
//				jsonCandidat = new JSONObject();			
//				jsonCandidat.put("firstname", candidat.getNom());
//				jsonCandidat.put("lastname", candidat.getPostnom());
//				jsonCandidat.put("nickname", candidat.getPrenom());
//				//jsonObj.put("phone", candidat.getPhone());
//				//jsonObj.put("email", candidat.getEmail());
//				//jsonObj.put("dateNaissance", candidat.getDateNaissance());
//				jsonObj.put("customer", jsonCandidat);
//				jsonObj.put("reference", candidat.getReference());
//				//jsonObj.put("isCustomerUniqueCodeValid", candidat.isCodeValide());
//				//jsonObj.put("typePieceIdentite", candidat.getTypePieceIdentite());
//				//jsonObj.put("numeroPieceIdentite", candidat.getNumeroPieceIdentite());
//				jsonObj.put("resultCode", 1);
//				jsonObj.put("resultMessage", "Entry found");
//
//				return (jsonObj.toString());
//			}else {
//				jsonObj = new JSONObject();
//				jsonObj.put("resultMessage", "No entry");
//				jsonObj.put("resultCode", 0);
//				return (jsonObj.toString());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return null;
//	}

	public boolean saveOrUpdateCandidatSubscription(CandidatSubscription pers) {
		CandidatSubscription candidatSubscription = candidatSubscriptionRepository.save(pers);

		if (candidatSubscriptionRepository.findById(candidatSubscription.getId()) != null) {
			return true;
		}
		return false;
	}
	
	public  String shuffleString(String input) {
        // Convert the string to a list of characters
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }

        // Shuffle the list
        Collections.shuffle(characters);

        // Convert the list back to a string
        StringBuilder shuffled = new StringBuilder();
        for (char c : characters) {
            shuffled.append(c);
        }

        return shuffled.toString();
    }

	@Override
	public String getCandidat(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CandidatSubscription> getCandidatSubscriptionByCandidatId(long id) {
		// TODO Auto-generated method stub
		return (List<CandidatSubscription>)candidatSubscriptionRepository.getCandidatSubscriptionByCandidatId(id);
	}


}
