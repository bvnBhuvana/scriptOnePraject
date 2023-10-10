package com.slokam.scriptone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
public class SceneElementOrder {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="sceId")
	private Scene scene;
	private Integer sequenceOrderNumber;
	
	
	
}
