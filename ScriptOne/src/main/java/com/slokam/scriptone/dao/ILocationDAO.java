package com.slokam.scriptone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Location;
import com.slokam.scriptone.entity.Scene;


@Repository
public interface ILocationDAO extends JpaRepository<Location, Long>{
	
	@Query("SELECT s.location FROM Scene s WHERE s.id = ?1")
	public Location getLocation(Long sid);
	
	
	public Location findByName(String name);




}
