package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.pe.model.TourPackage;
import com.idat.pe.repository.ITourPackageRepository;

@Service
@Transactional
public class TourPackageService {

	
	@Autowired
	ITourPackageRepository dao;
	
	public List<TourPackage> findByAll(){
		return  (List<TourPackage>) dao.findAll();
	}
	
	public TourPackage findById(Integer id ) {
		return dao.findById(id).get();
	}
	
	public TourPackage save(TourPackage tour) {
		return dao.save(tour);
	}

	public TourPackage update(TourPackage tour) {
		return dao.save(tour);
	} 	
	
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	public boolean existsTourPackage(Integer id) {
		
		return dao.existsById(id);
	}
	
}
