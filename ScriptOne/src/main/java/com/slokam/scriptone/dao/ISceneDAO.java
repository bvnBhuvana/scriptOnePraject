package com.slokam.scriptone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Scene;



@Repository
public interface ISceneDAO extends JpaRepository<Scene, Long>{
	@Query("select s from Scene s where s.script.id=?1")
	List<Scene> getScenes(Long scriptId);
}
