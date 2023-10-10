package com.slokam.scriptone.service;


import java.util.List;

import com.slokam.scriptone.dto.SceneDTO;
import com.slokam.scriptone.dto.ScriptDTO;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;
import com.slokam.scriptone.exception.UserInputException;

public interface IScriptService {

	public ScriptDTO savescript(ScriptDTO scriptdTO) throws UserInputException, Exception;
	
	public ScriptDTO getbyId(Long id);
	
	public List<ScriptDTO> getall();
	
	public List<SceneDTO> getListScenes(Long id) throws DataNotFoundException,ApplicationException,Exception ;
    

}
