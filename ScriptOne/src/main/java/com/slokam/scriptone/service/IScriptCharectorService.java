package com.slokam.scriptone.service;

import java.util.List;

import com.slokam.scriptone.dto.ScriptCharectorDTO;
import com.slokam.scriptone.exception.ApplicationException;

public interface IScriptCharectorService {

	public ScriptCharectorDTO  saveScriptCharector(ScriptCharectorDTO charector)throws ApplicationException,Exception;
    public ScriptCharectorDTO  getScriptCharectorById(Long charectorId) throws ApplicationException,Exception; 
    public ScriptCharectorDTO  deletecriptCharector(Long charectorId)throws ApplicationException,Exception;
    public List<ScriptCharectorDTO> getAllCharector() throws ApplicationException,Exception;
 
}
