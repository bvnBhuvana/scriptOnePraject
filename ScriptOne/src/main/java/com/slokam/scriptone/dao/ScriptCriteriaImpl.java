package com.slokam.scriptone.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.scriptone.entity.Scene;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;

import com.slokam.scriptone.dto.SceneCriteriaDTO;
import com.slokam.scriptone.entity.*;
@Slf4j
@Service
public class ScriptCriteriaImpl {

	@Autowired
	private EntityManager entityManager;
	
	
	public List<Scene> getScenes(SceneCriteriaDTO sceneCriteriaDTO)
			throws DataNotFoundException,ApplicationException,Exception {
		CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		CriteriaQuery<Scene> criteriaQuery= criteriaBuilder.createQuery(Scene.class);
		Root<Scene> rootScene=criteriaQuery.from(Scene.class);
		Join<Scene, Location> locationJoin=rootScene.join("location");
		Join<Scene,Script> scriptJoin=rootScene.join("script");
		//Join<Dialogue,Scene> dialogueJoin=rootScene.join("dialogue");
		//Join<Dialogue,ScriptCharector> scriptCharectorJoin=dialogueJoin.join("scriptcharector");
		
		
		List<Predicate> predicates=new ArrayList();
		//Long scriptId,String locationName,String scriptChar
		if(sceneCriteriaDTO.getScriptId()!=null) {
			
			 predicates.add(criteriaBuilder.equal(scriptJoin.get("id"),sceneCriteriaDTO.getScriptId()));
		}
		
		if(sceneCriteriaDTO.getLocationName()!=null && !sceneCriteriaDTO.getLocationName().trim().isEmpty()) {
			predicates.add(criteriaBuilder.equal(locationJoin.get("name") ,sceneCriteriaDTO.getLocationName() ));
		}
		
	
		
		criteriaQuery.select(rootScene).where(criteriaBuilder.or(predicates.toArray(new Predicate[2])));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}



