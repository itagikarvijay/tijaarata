package com.tijaarata.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@Embeddable
@MappedSuperclass
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
