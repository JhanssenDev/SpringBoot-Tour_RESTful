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

import com.idat.pe.model.Tour;
import com.idat.pe.service.TourService;

@RestController
@RequestMapping("/tour")
public class TourController {

	@Autowired
	TourService dao;

	@GetMapping
	public ResponseEntity<List<Tour>> listTours() {
		return ResponseEntity.status(HttpStatus.OK).body(dao.findByAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tour> findById(@PathVariable("id") Integer id) {

		if (id == null || id < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No found, bad parameters");
		}

		return new ResponseEntity<Tour>(dao.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Tour> saveTour(@RequestBody Tour tour) {

		if (tour.getId() == null || tour.getId() < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request id required");
		}
		if (dao.existsTour(tour.getId())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Id exists");
		}

		return new ResponseEntity<Tour>(dao.save(tour), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Tour> updateTour(@RequestBody Tour tour) {

		if (tour.getId() == null || tour.getId() < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request id required");
		}
		

		return new ResponseEntity<Tour>(dao.save(tour), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		dao.delete(id);
		return new ResponseEntity<Object>("Tour delete, Success!", HttpStatus.OK);
	}

}
