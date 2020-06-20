package com.tijaarata.master.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<CategoryEntity,Integer> {

}
