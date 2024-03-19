package com.team1oopco.OutpatientClinicManagementSystem.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personnelid")
abstract public class Personnel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int personnelid;
	protected String personnelName;
	//protected int dateHired;
	protected String address;
	protected int telephone;
	
	public Personnel(int personnelid, String personnelName, String address, int telephone) {
		this.personnelid = personnelid;
		this.personnelName = personnelName;
		this.address = address;
		this.telephone = telephone;
	}

	public Personnel() {
	}

	public int getPersonnelid() {
		return personnelid;
	}

	public void setPersonnelid(int personnelid) {
		this.personnelid = personnelid;
	}

	public String getPersonnelName() {
		return personnelName;
	}

	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Personnel [personnelid=" + personnelid + ", personnelName=" + personnelName + ", address=" + address
				+ ", telephone=" + telephone + "]";
	}
		
}
