package com.slokam.scriptone.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LocationDTO {
	@NotNull
	private Long id;
    private String name;
    private Integer typeId;
    
}
