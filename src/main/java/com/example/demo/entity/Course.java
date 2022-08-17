package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 25 , nullable =false, unique = true )
	private String name;
	@Column(length = 25 , nullable =false )
	private Integer credit;
	public Course(Integer id, String name, Integer credit) {
		this.id = id;
		this.name = name;
		this.credit = credit;
	}
	public Course() {
	
	}
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
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return this.name;
	}
}