package com.slokam.scriptone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.scriptone.entity.LocationType;

@Repository
public interface IlocationTypeDao extends JpaRepository<LocationType, Integer>{

}
