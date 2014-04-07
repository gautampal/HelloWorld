package com.gautam.dbentities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.AccessType;

import com.sun.istack.internal.NotNull;

@Entity
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1210826043794116981L;
	
	@Id
	@SequenceGenerator(name = "integrationSequence", sequenceName = "SQ_INTEGRATIONS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "integrationSequence")
	@AccessType("property")
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false, targetEntity = VehicleDetails.class)
	@PrimaryKeyJoinColumn(referencedColumnName = "id")
	@JoinColumn(name = "id", insertable = true)
	@NotNull
	private VehicleDetails details;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VehicleDetails getDetails() {
		return details;
	}
	public void setDetails(VehicleDetails details) {
		this.details = details;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
