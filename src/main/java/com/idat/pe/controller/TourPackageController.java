package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idat.pe.model.TourPackage;
import com.idat.pe.service.TourPackageService;

@RestController
@RequestMapping("/tourPackage")
public class TourPackageController {

	@Autowired
	TourPackageService dao;
	
	@GetMapping
	public ResponseEntity<List<TourPackage>> listTourPackages() {
		return ResponseEntity.status(HttpStatus.OK).body(dao.findByAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TourPackage> findById(@PathVariable("id") Integer id) {

		if (id == null || id < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No found, bad parameters");
		}

		return new ResponseEntity<TourPackage>(dao.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TourPackage> saveTourPackage(@RequestBody TourPackage TourPackage) {

		if (TourPackage.getId() == null || TourPackage.getId() < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request id required");
		}
		if (dao.existsTourPackage(TourPackage.getId())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Id exists");
		}

		return new ResponseEntity<TourPackage>(dao.save(TourPackage), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<TourPackage> updateTourPackage(@RequestBody TourPackage TourPackage) {

		if (TourPackage.getId() == null || TourPackage.getId() < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request id required");
		}
		

		return new ResponseEntity<TourPackage>(dao.save(TourPackage), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		dao.delete(id);
		return new ResponseEntity<Object>("TourPackage delete, Success!", HttpStatus.OK);
	}

	
}
