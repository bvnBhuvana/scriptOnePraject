package com.slokam.scriptone.service;

import java.util.List;

import com.slokam.scriptone.dto.TimeDTO;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;

public interface ITimeService {

	public TimeDTO save(TimeDTO timedto) throws ApplicationException,Exception;
	
	public TimeDTO getById(Integer id);
	
	public List<TimeDTO> getAll();
	
	public TimeDTO deleteById(Integer id);
}
