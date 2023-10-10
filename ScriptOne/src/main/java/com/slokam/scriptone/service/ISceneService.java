package com.slokam.scriptone.service;

import com.slokam.scriptone.dto.SceneDTO;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;

public interface ISceneService {

	public SceneDTO saveScene(SceneDTO sceneDTO)
	  throws DataNotFoundException,ApplicationException,Exception;
	
	public SceneDTO getSceneById(Long id) throws DataNotFoundException, ApplicationException, Exception;
	
	public SceneDTO deleteScene(Long id)  throws DataNotFoundException, ApplicationException, Exception;
	
	public SceneDTO updateScene(SceneDTO sceneDTO) throws DataNotFoundException, ApplicationException, Exception;


}
