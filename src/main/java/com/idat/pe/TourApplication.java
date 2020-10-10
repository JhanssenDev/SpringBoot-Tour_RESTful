package com.idat.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.idat.pe.repository.ITourPackageRepository;
import com.idat.pe.repository.ITourRepository;

@SpringBootApplication
public class TourApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext conf =  SpringApplication.run(TourApplication.class, args);
		
		
		ITourPackageRepository servTP = conf.getBean(ITourPackageRepository.class);
		ITourRepository serT = conf.getBean(ITourRepository.class);
		
	
//		servTP.save( new TourPackage(1, "Package I") );
//		servTP.save( new TourPackage(2, "Package II") );
//		servTP.save( new TourPackage(3, "Package III") );
		
//		TourPackage tp1 = servTP.findById(3).get() ;
//		
//		serT.save(new Tour(3, "Tour 3", "", "Instagram", "1500", "4 Days", "4", "T3", tp1, Region.Northern_california, Difficulty.Medium));
//		
	}

}
