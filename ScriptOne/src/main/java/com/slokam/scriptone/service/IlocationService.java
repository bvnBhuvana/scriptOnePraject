package com.slokam.scriptone.service;

import java.util.List;

import com.slokam.scriptone.dto.LocationTypeDto;



public interface IlocationService {
	
	
	public LocationTypeDto save(LocationTypeDto loctypedto);
	public LocationTypeDto getbyid(Integer id);
	public List<LocationTypeDto> getbyall();
	public LocationTypeDto deletebyid(Integer id);
	

}
