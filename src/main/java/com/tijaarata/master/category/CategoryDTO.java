/**
 * 
 */
package com.tijaarata.master.category;

/**
 * @author User
 *
 */
public class CategoryDTO {

	private Integer Id;
	
	private String name;

	public CategoryDTO() {

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
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
