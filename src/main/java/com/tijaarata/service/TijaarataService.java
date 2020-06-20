package com.tijaarata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tijaarata.entity.TijaarataEntity;
import com.tijaarata.repo.ITijaarataRepo;

@Service
public class TijaarataService implements ITijaarataService {
	
	@Autowired
	ITijaarataRepo schoolRepo;

	@Override
	public Optional<TijaarataEntity> getSchool() {
		
		return schoolRepo.findById(1);
	}
	

}
