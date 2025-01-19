package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int sid;
	private String sname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lid")
	private Laptop laptop;

	public Student() {

	}

	public Student(int sid, String sname, Laptop laptop) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.laptop = laptop;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", laptop=" + laptop + "]";
	}

}
