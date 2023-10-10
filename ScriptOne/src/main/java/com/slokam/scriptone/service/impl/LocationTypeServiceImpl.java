package com.slokam.scriptone.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.scriptone.dao.IlocationTypeDao;
import com.slokam.scriptone.dto.LocationTypeDto;
import com.slokam.scriptone.dto.ScriptDTO;
import com.slokam.scriptone.entity.LocationType;
import com.slokam.scriptone.entity.Script;
import com.slokam.scriptone.service.IlocationService;

@Service
public class LocationTypeServiceImpl implements IlocationService {
	
	@Autowired
	private IlocationTypeDao iLocationDao;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public LocationTypeDto save(LocationTypeDto loctypedto) {
		         
		   LocationType locationtype =  modelmapper.map(loctypedto, LocationType.class);       
		   iLocationDao.save(locationtype);
		   loctypedto.setId(locationtype.getId());
		   
		return loctypedto;
	}

	@Override
	public LocationTypeDto getbyid(Integer id) {
	
		LocationTypeDto loctypedto = null;
		   Optional<LocationType> loctype =  iLocationDao.findById(id);
		    if(loctype.isPresent())
		     {
		        LocationType loc =  loctype.get();
		  	 loctypedto =  	modelmapper.map(loc, LocationTypeDto.class);
		     }
		return loctypedto;
	}

	@Override
	public List<LocationTypeDto> getbyall() {
		 List<LocationTypeDto> locationtypedto = new ArrayList<>();
		 LocationTypeDto locationdto = null;
	     List<LocationType>  loclist =   iLocationDao.findAll();
	   
	     for(LocationType loc : loclist)
	     {
	    	 locationdto =  modelmapper.map(loc, LocationTypeDto.class);
	    	 locationtypedto.add(locationdto);
	    	
	     }
		return locationtypedto;
	}

	@Override
	public LocationTypeDto deletebyid(Integer id) {
		     LocationTypeDto loctypedto =  getbyid(id);
		     iLocationDao.deleteById(id);
		return loctypedto;
	}
	
	
	                   	
	
	

}
