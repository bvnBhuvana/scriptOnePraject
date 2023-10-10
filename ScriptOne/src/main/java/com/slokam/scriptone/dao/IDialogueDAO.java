package com.slokam.scriptone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Dialogue;


@Repository
public interface IDialogueDAO extends JpaRepository<Dialogue, Long>{
	@Query("select d from Dialogue d where d.scene.id =?1")
    public List<Dialogue> getDialogueList(Long sceneId);
	
	


}
