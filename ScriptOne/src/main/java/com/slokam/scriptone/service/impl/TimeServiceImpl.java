package com.slokam.scriptone.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.scriptone.controller.TimeController;
import com.slokam.scriptone.dao.ITimeDAO;
import com.slokam.scriptone.dto.TimeDTO;
import com.slokam.scriptone.entity.Time;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;
import com.slokam.scriptone.service.ITimeService;



@Service
public class TimeServiceImpl implements ITimeService {

	@Autowired
	private ITimeDAO timeDao;
	
	@Autowired
	private ModelMapper modelmapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeController.class);

	
	@Override
	public TimeDTO save(TimeDTO timeDto) throws ApplicationException ,Exception {
		
		
		
		LOGGER.info("method started by passing  timedto { } "+timeDto.toString());
		
		Time time= modelmapper.map(timeDto,Time.class);
		
		// time.setDescription(timeDto.getDescription());
		
		timeDao.save(time);

		timeDto.setId(time.getId());
		LOGGER.info("method ended by returning timeDto {} "+time.toString());
		return timeDto;
	}

	
	@Override
	public TimeDTO getById(Integer id) {
		
	Optional<Time> opttime =	timeDao.findById(id);
	
	TimeDTO timedto = null;
	if(opttime.isPresent())
	{
		Time time = opttime.get();
		timedto =	modelmapper.map(time, TimeDTO.class);
		
	}
		return timedto;
	}


	@Override
	public List<TimeDTO> getAll() {
		
		List<Time> listtime = timeDao.findAll();
		List<TimeDTO> listTimedto = new ArrayList<>();
		
		for(Time time:listtime)
		{
			TimeDTO timedto =modelmapper.map(time, TimeDTO.class);
			listTimedto.add(timedto);
		}
		return listTimedto;
	}
	
	@Override
	public TimeDTO deleteById(Integer id)
	{
		
		TimeDTO timedto = null;
		Optional<Time> opt = timeDao.findById(id);
		if(opt.isPresent())
		{
			Time time = opt.get();
			 timedto =modelmapper.map(time, TimeDTO.class);
			 timeDao.deleteById(id);
	}
		return timedto;
	
	}

}
