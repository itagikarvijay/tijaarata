/**
 * 
 */
package com.tijaarata.master.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tijaarata.mapper.MapperClz;

/**
 * @author User
 *
 */
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	IProductRepo productRepo;
	
	@Autowired
	MapperClz<?> mapperClz;
	
	@Override
	@Cacheable(cacheNames = "productsCache")
	public List<ProductDTO> findAll() {
		return mapperClz.convertToDto(productRepo.findAll());
	}

}
