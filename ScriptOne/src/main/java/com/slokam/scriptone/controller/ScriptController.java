package com.slokam.scriptone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.scriptone.dto.SceneDTO;
import com.slokam.scriptone.dto.ScriptDTO;

import com.slokam.scriptone.exception.UserInputException;

import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;
import com.slokam.scriptone.service.IScriptService;

@RestController
@RequestMapping("script")
public class ScriptController {
	
	@Autowired
	private IScriptService iscriptser;

	@PostMapping("/savescript")
	public ResponseEntity<ScriptDTO> savescript(@RequestBody ScriptDTO scriptdto) throws UserInputException, Exception
	{
	  scriptdto = iscriptser.savescript(scriptdto);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(scriptdto);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ScriptDTO> getbyId(@PathVariable Long id) {
		ScriptDTO scriptdto = iscriptser.getbyId(id);


		return ResponseEntity.status(HttpStatus.OK).body(scriptdto);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ScriptDTO>> getAll()
	{
	 List<ScriptDTO> listsdto =	iscriptser.getall();
	 
		return ResponseEntity.status(HttpStatus.OK).body(listsdto);
		
	}
	@GetMapping("/getAllScenes/{scriptId}")
	public ResponseEntity<List<SceneDTO>> getAllScenes(@PathVariable Long scriptId) throws DataNotFoundException,ApplicationException, Exception {
		List<SceneDTO> lostOfSceneDtos= iscriptser.getListScenes(scriptId);
		return ResponseEntity.status(HttpStatus.OK).body(lostOfSceneDtos);
	}
	

}
