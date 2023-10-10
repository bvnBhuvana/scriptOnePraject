package com.slokam.scriptone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Scene;
import com.slokam.scriptone.entity.Script;


@Repository
public interface IScriptDAO extends JpaRepository<Script, Long>{

	
}
