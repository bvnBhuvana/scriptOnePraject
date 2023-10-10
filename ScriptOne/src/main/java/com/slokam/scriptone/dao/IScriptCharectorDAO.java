package com.slokam.scriptone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.ScriptCharector;


@Repository
public interface IScriptCharectorDAO extends JpaRepository<ScriptCharector, Long>{
	
     

	@Query("SELECT st FROM Dialogue d JOIN d.scriptCharector st JOIN d.scene s WHERE s.id = ?1")
	public ScriptCharector getScriptCharector(Long id);
   
    public ScriptCharector findByName(String name);

}


