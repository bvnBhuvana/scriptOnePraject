package com.slokam.scriptone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.scriptone.dto.LocationDTO;
import com.slokam.scriptone.dto.SceneDTO;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;
import com.slokam.scriptone.exception.UserInputException;
import com.slokam.scriptone.service.ISceneService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("scene")
public class SceneController {
	
	@Autowired
	private ISceneService sceneService;
	@PostMapping
	public ResponseEntity<SceneDTO> saveScene(@RequestBody @Valid SceneDTO sceneDto)
	throws DataNotFoundException,ApplicationException,UserInputException,Exception{
		LocationDTO locationDto= sceneDto.getLocationDto();
		
		if(locationDto.getId()==null ) {
			if( locationDto.getName()==null || locationDto.getName().trim().length()==0 ||
			    locationDto.getTypeId()==null		
					) {
				throw new UserInputException("Location Data invalid");
			}
		}
		
		log.debug(sceneDto.toString());
		SceneDTO sceneDtos= sceneService.saveScene(sceneDto);
		return ResponseEntity.status(HttpStatus.OK).body(sceneDtos);
	}
	
	@GetMapping("/getscene/{id}") 
	public ResponseEntity<SceneDTO> getSceneById(@PathVariable Long id) throws DataNotFoundException, ApplicationException, Exception
	{
		SceneDTO sceneDto= sceneService.getSceneById(id);
		return ResponseEntity.status(HttpStatus.OK).body(sceneDto);
	}
	
	@DeleteMapping("/deletescene/{id}")
	public ResponseEntity<SceneDTO> DeleteSceneById(@PathVariable Long id)  throws DataNotFoundException, ApplicationException, Exception{
		SceneDTO sceneDto=sceneService.deleteScene(id);
		return ResponseEntity.status(HttpStatus.OK).body(sceneDto);
	}
	@PutMapping("/updatescene")
	public ResponseEntity<SceneDTO> updatedScene(@RequestBody SceneDTO sceneDto) throws DataNotFoundException, ApplicationException, Exception{
		SceneDTO newSceneDto=sceneService.updateScene(sceneDto);
		return ResponseEntity.status(HttpStatus.OK).body(sceneDto);
	}
	 
}
