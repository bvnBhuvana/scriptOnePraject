package com.slokam.scriptone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Action;
import com.slokam.scriptone.entity.Scene;



@Repository
public interface IActionDAO extends JpaRepository<Action, Long> {

	@Query("select a from Action a join a.scene s where s.id=?1")
	List<Action> getActions(Long sceneId);


    

}
