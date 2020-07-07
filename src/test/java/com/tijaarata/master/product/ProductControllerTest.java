/**
 * 
 */
package com.tijaarata.master.product;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author User
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	ProductServiceImplTest productServiceImplTest;
	
    @BeforeEach
    void setMockOutput() {
    	 List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
    	 ProductDTO e = new ProductDTO();
    	 e.setName("Toned");
     	 productDTOList.add(e);
         when(productServiceImplTest.findAll()).thenReturn(productDTOList);
    }

	@Test
	@WithMockUser(username = "ravan", authorities = { "ADMIN", "USER" })
	public void getAll() throws Exception {

		mvc.perform(get("/api/product/products").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//			      .andExpect(jsonPath("$", hasSize(1)))
			      .andExpect(jsonPath("$[0].name", is("Toned")));
	}
	
	@Test
	public void getAllService()throws Exception {
		assertEquals(1,productServiceImplTest.findAll().size());
		verify(productServiceImplTest).findAll();
	}
 }
