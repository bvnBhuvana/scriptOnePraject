package com.slokam.scriptone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.SceneElementOrder;


@Repository
public interface ISceneElementOrderDAO extends JpaRepository<SceneElementOrder, Long>{

}
