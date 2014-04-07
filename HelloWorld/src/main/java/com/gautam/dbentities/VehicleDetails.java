package com.gautam.dbentities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.gautam.helpers.VehicleType;

@Entity
@GenericGenerator(name = "VehicleDetails", strategy = "foreign",
parameters =
{
  @Parameter
  (
    name = "property", value = "vehicle"
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
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private VehicleType type;
	
	@Column
	private Integer numberOfTyres;
	
	@OneToOne
    @JoinColumn(name = "id")
	private Vehicle vehicle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public Integer getNumberOfTyres() {
		return numberOfTyres;
	}

	public void setNumberOfTyres(Integer numberOfTyres) {
		this.numberOfTyres = numberOfTyres;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.name = vehicle.getName();
	}
	
}
