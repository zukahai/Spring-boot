package com.haizuka.service.impl;

import java.util.List;

import haizuka.dto.HaiZukaDTO;

public interface IHaizukaService {
	HaiZukaDTO save(HaiZukaDTO dto);
	HaiZukaDTO update(HaiZukaDTO dto);
	void delete(int ids[]);
	List<HaiZukaDTO> findAll(); 
}
