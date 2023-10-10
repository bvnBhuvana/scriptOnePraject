package com.slokam.scriptone.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.scriptone.dto.SceneCriteriaDTO;
import com.slokam.scriptone.entity.Scene;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;

@RestController
public class ScriptCriteriaController {
	@Autowired
	private ScriptCriteriaImpl serviceCriteria;
	@GetMapping("/criteria")
	public ResponseEntity<List<Scene>> getScenesList(@RequestBody SceneCriteriaDTO  userInput)
			throws DataNotFoundException,ApplicationException,Exception {
		 List<Scene> scenesList= serviceCriteria.getScenes(userInput);
		 if(scenesList.isEmpty()) {
			 return ResponseEntity.notFound().build();
		 }
		 
		 return ResponseEntity.status(HttpStatus.OK).body(scenesList);
	}
	
	
}
// Long scriptId, String locationName,String scriptChar