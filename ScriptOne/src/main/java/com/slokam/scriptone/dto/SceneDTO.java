package com.slokam.scriptone.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SceneDTO {

	private Long id;
	private LocationDTO locationDto;
	@NotNull
	private Integer timeId;
	@NotNull
	private Long scriptId;
	private List<ActionDTO> actionList;
    private List<DialogueDTO> dialogueList;
    
    
    

}
