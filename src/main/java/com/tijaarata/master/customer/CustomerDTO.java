/**
 * 
 */
package com.tijaarata.master.customer;

import com.tijaarata.dto.BaseDTO;

/**
 * @author User
 *
 */
public class CustomerDTO extends BaseDTO {

	private Integer id;

	private String name;

	public CustomerDTO() {

	}
	
	public CustomerDTO(String name) {
		this.name = name;
	}
	

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
