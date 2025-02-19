package com.hoja.cnprapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoja.cnprapi.models.CnprQuestion;


public interface QuestionRepository extends JpaRepository<CnprQuestion, Long>{

	
	@Query(value="select t.id,t.active_status,t.audio_url,t.created_at,t.description,t.image_url,t.last_updated_at,t.title,t.video_url,t.created_by,t.lesson,t.lesson_module,t.type_permis,t.reponse from public.tb_cnpr_question t",nativeQuery=true)
	List<CnprQuestion> getAllCnprQuestion();
	
	@Query("SELECT new CnprQuestion(t.id, t.title, t.videoUrl, t.reponse,t.lesson,t.lessonModule,t.typePermis) FROM CnprQuestion t where t.activeStatus=true")
	List<CnprQuestion> getAllActiveCnprQuestion();

	@Query("SELECT t FROM CnprQuestion t")
	Page<CnprQuestion> getAllPageable(Pageable pageable);
	

	
}
