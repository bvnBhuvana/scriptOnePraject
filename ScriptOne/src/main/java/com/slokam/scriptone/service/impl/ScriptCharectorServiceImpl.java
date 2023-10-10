package com.slokam.scriptone.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.slokam.scriptone.dao.IScriptCharectorDAO;
import com.slokam.scriptone.dao.IScriptDAO;
import com.slokam.scriptone.dto.ScriptCharectorDTO;
import com.slokam.scriptone.entity.Script;
import com.slokam.scriptone.entity.ScriptCharector;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;
import com.slokam.scriptone.service.IScriptCharectorService;

@Service
public class ScriptCharectorServiceImpl implements IScriptCharectorService {

	@Autowired
	private IScriptCharectorDAO scriptCharectorDAO;
	@Autowired
	private IScriptDAO scriptDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ScriptCharectorDTO saveScriptCharector(ScriptCharectorDTO charectorDto)
			throws ApplicationException, Exception {

		// ScriptCharector sc = modelMapper.map(charectorDto, ScriptCharector.class);
		Optional<Script> scriptOpt = scriptDao.findById(charectorDto.getScriptId());
		if (scriptOpt.isPresent()) {
			Script script = scriptOpt.get();
			ScriptCharector sc = new ScriptCharector();
			sc.setName(charectorDto.getName());
			sc.setScript(script);
			scriptCharectorDAO.save(sc);
			charectorDto.setId(sc.getId());
		}

		return charectorDto;
	}

	@Override
	public ScriptCharectorDTO getScriptCharectorById(Long charectorId)
			throws ApplicationException, DataNotFoundException, Exception {

		Optional<ScriptCharector> opt = scriptCharectorDAO.findById(charectorId);
		if (!opt.isPresent()) {
			throw new DataNotFoundException("Script charector id not found while reading data.");
		}

		ScriptCharector scriptCharector = opt.get();
		ScriptCharectorDTO scriptCharDto = modelMapper.map(scriptCharector, ScriptCharectorDTO.class);

		return scriptCharDto;
	}

	@Override
	public ScriptCharectorDTO deletecriptCharector(Long charectorId)
			throws ApplicationException, DataNotFoundException, Exception {
		ScriptCharectorDTO scriptCharDto = null;
		Optional<ScriptCharector> opt = scriptCharectorDAO.findById(charectorId);
		if (opt.isPresent()) {
			ScriptCharector scriptCharector = opt.get();
			scriptCharDto = modelMapper.map(scriptCharector, ScriptCharectorDTO.class);
			scriptCharectorDAO.deleteById(charectorId);
		} else {
			throw new DataNotFoundException("Script charector not found while deleting.");
		}
		return scriptCharDto;
	}

	@Override
	public List<ScriptCharectorDTO> getAllCharector() throws ApplicationException, Exception {
		
		List<ScriptCharector> list = scriptCharectorDAO.findAll();
		
		/*
		ScriptCharectorDTO[] arrData= modelMapper.map(list, ScriptCharectorDTO[].class);
		
		List<ScriptCharectorDTO> list2=  Arrays.asList(arrData);
		*/
		
		if(list.isEmpty()) {
			throw new DataNotFoundException("No script cherects are found");
		}
		
		List<ScriptCharectorDTO> dtoList = 
				Arrays.asList(modelMapper.map(list, ScriptCharectorDTO[].class));
		
		return dtoList;
	}

}
