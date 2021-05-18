package com.dummy.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.demo.controller.dto.ProductDto;

import java.time.LocalDateTime;
import java.util.ArrayList; 
import java.util.Map;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="api")
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")	
	@ResponseBody
	public ResponseEntity<?> findAllTask(@RequestParam Map<String,String> parametros)  {
		ProductDto d1 = new ProductDto();
		ProductDto d2 = new ProductDto();
		ProductDto d3 = new ProductDto(); 
		logger.info("===LIST TASK==== BEGIN ===="); 
		
		
		logger.info("===LIST TASK==== END ====");
		return ResponseEntity.status(HttpStatus.OK).body(dataDummy());
	}
	
	List<ProductDto> dataDummy(){
		ProductDto d1 = new ProductDto();
		ProductDto d2 = new ProductDto();
		ProductDto d3 = new ProductDto();
		List<ProductDto> result = new ArrayList<ProductDto>();
		
		d1.setCode("R001");
		d2.setCode("R002");
		d3.setCode("R003");
		
		d1.setName("Soda");
		d2.setName("Sniker");
		d3.setName("sandwich");
		
		d1.setPrice(1.5f);
		d2.setPrice(5.5f);
		d3.setPrice(3.5f);

		d1.setCreationDate(LocalDateTime.now());
		d2.setCreationDate(LocalDateTime.now());
		d3.setCreationDate(LocalDateTime.now());
		
		
		result.add(d1);
		result.add(d2);
		result.add(d3);
		
		return result;
		
	}
}
