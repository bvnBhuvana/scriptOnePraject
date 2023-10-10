package com.slokam.scriptone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.scriptone.dto.TimeDTO;
import com.slokam.scriptone.entity.Time;
import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.service.ITimeService;


@RestController
@RequestMapping("Time")
public class TimeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TimeController.class);

	@Autowired
	private ITimeService iTimeService;

	@PostMapping("/savetimedata")
	public ResponseEntity<TimeDTO> savetimedata(@RequestBody TimeDTO timeDto) throws ApplicationException, Exception {
		LOGGER.info(" iTimeService savetimedata Method is started ", timeDto);
		TimeDTO timedtos = iTimeService.save(timeDto);

		LOGGER.info("iTimeService savetimedata Method is ended ", timedtos);
		return ResponseEntity.status(HttpStatus.OK).body(timedtos);

	}

	@GetMapping("/{id}")
	public ResponseEntity<TimeDTO> getdataByID(@PathVariable Integer id) {
		LOGGER.info("iTimeService  getdataByID Method stated with passing id {} ", id);
		TimeDTO getTimeDto = iTimeService.getById(id);
		
		LOGGER.info("iTimeService getdataByID Method eneded with by returning ",getTimeDto);
		return ResponseEntity.status(HttpStatus.OK).body(getTimeDto);

	}

	@GetMapping("/getall")
	public ResponseEntity<List<TimeDTO>> getAll() {
		LOGGER.info("iTimeService getAll method is Started {}");
		List<TimeDTO> GetAllTimeDtos = iTimeService.getAll();
		
		LOGGER.info("iTimeService getAll method is ended by returning the GetAllTimeDtos { }",GetAllTimeDtos.toString());
		return ResponseEntity.status(HttpStatus.OK).body(GetAllTimeDtos);
	}

	@DeleteMapping("/deleteby/{id}")
	public ResponseEntity<TimeDTO> deleteById(@PathVariable Integer id) {
		LOGGER.info("iTimeService deleteById method started with passing id { }",id);
		TimeDTO deleteTimeDto = iTimeService.deleteById(id);
		
		LOGGER.info("iTimeService deleteById Method ended by returning deleteTimeDto { }"+deleteTimeDto.toString());
		return ResponseEntity.status(HttpStatus.OK).body(deleteTimeDto);
	}

}
