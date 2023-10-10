package com.slokam.scriptone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Scene;
@Repository
public interface IScriptCriteriaDao extends JpaRepository<Scene, Long> {

	//public List<Scene> getByLocationName(String locationName);
}
