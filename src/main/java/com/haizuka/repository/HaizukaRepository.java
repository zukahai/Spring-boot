package com.haizuka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haizuka.entity.HaizukaEntity;

public interface HaizukaRepository extends JpaRepository<HaizukaEntity, Integer>{

}
