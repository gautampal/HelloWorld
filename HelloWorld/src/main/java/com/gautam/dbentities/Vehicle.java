package com.gautam.dbentities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1210826043794116981L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false)
	public Integer ID;
	@Column(unique = true, nullable = false)
	public String name;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(referencedColumnName = "ID")
	public VehicleDetails details;
}
