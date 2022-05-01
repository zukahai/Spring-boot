package com.haizuka.converter;

import org.springframework.stereotype.Component;

import com.haizuka.entity.HaizukaEntity;

import haizuka.dto.HaiZukaDTO;

@Component
public class HaizukaConverter {
	public HaizukaEntity toEntity(HaiZukaDTO dto) {
		HaizukaEntity haizukaEntity = new HaizukaEntity();
		haizukaEntity.setId(dto.getId());
		haizukaEntity.setUserName(dto.getUserName());
		haizukaEntity.setPassword(dto.getPassword());
		return haizukaEntity;
	}
	
	public HaiZukaDTO toDTO(HaizukaEntity entity) {
		HaiZukaDTO haiZukaDTO = new HaiZukaDTO();
		haiZukaDTO.setId(entity.getId());
		haiZukaDTO.setUserName(entity.getUserName());
		haiZukaDTO.setPassword(entity.getPassword());
		return haiZukaDTO;
	}
}
