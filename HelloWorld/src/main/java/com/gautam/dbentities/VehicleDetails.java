package com.gautam.dbentities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.gautam.helpers.VehicleType;

@Entity
@GenericGenerator(name = "VehicleDetails", strategy = "foreign",
parameters =
{
  @Parameter
  (
    name = "property", value = "ID"
  )
}
)
public class VehicleDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -149000774821947690L;
	@Id
	@GeneratedValue(generator = "VehicleDetails")
	public String ID;
	@Column(nullable = false)
	public VehicleType type;
	@Column
	public Integer numberOfTyres;
	
}
