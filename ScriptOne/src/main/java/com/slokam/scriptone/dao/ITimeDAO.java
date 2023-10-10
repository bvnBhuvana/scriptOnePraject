package com.slokam.scriptone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.Time;


@Repository
public interface ITimeDAO extends JpaRepository<Time, Integer>{

}
