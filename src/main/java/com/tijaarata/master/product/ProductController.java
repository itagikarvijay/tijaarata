package com.tijaarata.master.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@RequestMapping("/products")
	public List<ProductDTO> getAll(){
		return productService.findAll();
	}
}
