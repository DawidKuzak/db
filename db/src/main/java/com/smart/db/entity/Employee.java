package com.smart.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{
	@Id
	@Size(max = 11)
	private Integer emp_no;

	@NotNull
	private Date birth_date;

	@NotNull
	private Date hire_date;

	@NotNull
	private String first_name;

	@NotNull
	private String last_name;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private transient Set<Salary> salaries;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private transient Set<Title> titles;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private transient Set<WorksIn> works_ins;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private transient Set<DeptManager> deptManagers;

	public Employee() {

	}

	public Employee(@Size(max = 11) Integer emp_no, Date birth_date, Date hire_date, String first_name,
			String last_name) {
		super();
		this.emp_no = emp_no;
		this.birth_date = birth_date;
		this.hire_date = hire_date;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Integer getEmp_no() {
		return emp_no;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		return emp.getEmp_no().equals(emp_no);
	}

	@Override
	public String toString() {
		return "[emp_no=" + emp_no + ", first_name=" + first_name + ", last_name=" + last_name + ", birth_date="
				+ birth_date.toString() + ", hire_date=" + hire_date.toString() + "]";
	}
}
