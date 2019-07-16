package com.rev.BACalculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "getDrinks", query = "SELECT p FROM Preset p")
	})
@Table(name = "presets")
public class Preset {

	@Id
	@Column(name = "presetid")
	private int presetid;

	@Column(name = "name")
	private String name;

	@Column(name = "strength")
	private double strength;

	public int getPresetid() {
		return presetid;
	}

	public void setPresetid(int presetid) {
		this.presetid = presetid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	@Override
	public String toString() {
		return "Preset [presetid=" + presetid + ", name=" + name + ", strength=" + strength + "]";
	}
	
	public Preset() {
		
	}
}
