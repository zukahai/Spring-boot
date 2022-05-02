package com.haizuka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.haizuka.converter.HaizukaConverter;
import com.haizuka.entity.HaizukaEntity;
import com.haizuka.repository.HaizukaRepository;
import com.haizuka.service.impl.IHaizukaService;

import haizuka.dto.HaiZukaDTO;

@Service
public class HaiZukaService implements IHaizukaService{
	@Autowired
	private HaizukaRepository haizukaRepository;
	
	@Autowired
	private HaizukaConverter haizukaConverter;

	@Override
	public HaiZukaDTO save(HaiZukaDTO dto) {
		// TODO Auto-generated method stub
		HaizukaEntity haizukaEntity = haizukaConverter.toEntity(dto);
		haizukaEntity = haizukaRepository.save(haizukaEntity);
		HaiZukaDTO ans = haizukaConverter.toDTO(haizukaEntity);
		System.out.println("Add success " + ans);
		return ans;
	}

	@Override
	public HaiZukaDTO update(HaiZukaDTO dto) {
		// TODO Auto-generated method stub
		HaizukaEntity haizukaEntity = haizukaConverter.toEntity(dto);
		haizukaEntity = haizukaRepository.save(haizukaEntity);
		HaiZukaDTO ans = haizukaConverter.toDTO(haizukaEntity);
		System.out.println("Update success " + ans);
		return ans;
	}

	@Override
	public void delete(int[] ids) {
		// TODO Auto-generated method stub
		for (int id : ids) {
			haizukaRepository.deleteById(id);
		}
	}

	@Override
	public List<HaiZukaDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List <HaiZukaDTO> haiZukaDTOs = new ArrayList<HaiZukaDTO>();
		List <HaizukaEntity> entities = haizukaRepository.findAll(pageable).getContent();
		for (HaizukaEntity entity : entities) {
			HaiZukaDTO dto = haizukaConverter.toDTO(entity);
			haiZukaDTOs.add(dto);
		}
		return haiZukaDTOs;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) haizukaRepository.count();
	}

	@Override
	public List<HaiZukaDTO> findAll() {
		// TODO Auto-generated method stub
		List <HaiZukaDTO> haiZukaDTOs = new ArrayList<HaiZukaDTO>();
		List <HaizukaEntity> entities = haizukaRepository.findAll();
		for (HaizukaEntity entity : entities) {
			HaiZukaDTO dto = haizukaConverter.toDTO(entity);
			haiZukaDTOs.add(dto);
		}
		return haiZukaDTOs;
	}
}
