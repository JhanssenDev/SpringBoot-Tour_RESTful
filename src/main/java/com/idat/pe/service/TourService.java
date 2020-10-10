package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.pe.model.Tour;
import com.idat.pe.repository.ITourRepository;

@Service
@Transactional
public class TourService {
	
	@Autowired
	ITourRepository dao;
	
	public List<Tour> findByAll(){
		return  (List<Tour>) dao.findAll();
	}
	
	public Tour findById(Integer id ) {
		return dao.findById(id).get();
	}
	
	public Tour save(Tour tour) {
		return dao.save(tour);
	}

	public Tour update(Tour tour) {
		return dao.save(tour);
	} 	
	
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	public boolean existsTour(Integer id) {
		
		return dao.existsById(id);
	}
}
