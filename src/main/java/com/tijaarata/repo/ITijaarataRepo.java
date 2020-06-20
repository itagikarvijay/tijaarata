package com.tijaarata.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tijaarata.entity.TijaarataEntity;

@Repository
public interface ITijaarataRepo extends CrudRepository<TijaarataEntity,Integer> {

}
