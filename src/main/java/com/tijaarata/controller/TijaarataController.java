package com.tijaarata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tijaarata.dto.TijaarataDTO;
import com.tijaarata.mapper.MapperClz;
import com.tijaarata.service.ITijaarataService;

@RestController
@RequestMapping("/api")
public class TijaarataController {

	@Autowired
	ITijaarataService schoolService;

	@Autowired
	MapperClz mapperClz;

//	@GetMapping("/schoolDetails")
//	public ResponseEntity<TijaarataDTO> getSchool() {
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<>(mapperClz.convertToDto(schoolService.getSchool().get()), headers, HttpStatus.OK);
//	}


	@GetMapping("/someText")
	public String getSomeText() {
		return "SomeText";
	}
}
