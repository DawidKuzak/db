package com.smart.db.entity;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "titles")
@IdClass(TitleId.class)
public class Title {
	@Id
	@ManyToOne
	@JoinColumn(name = "emp_no", nullable = false)
	private Employee employee;

	@Id
	@Size(max = 50)
	private String title;

	@Id
	private Date from_date;

	public Title() {

	}

	public Title(Employee employee, @Size(max = 50) String title, Date from_date) {
		super();
		this.employee = employee;
		this.title = title;
		this.from_date = from_date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public String getTitle() {
		return title;
	}

	public Date getFrom_date() {
		return from_date;
	}

	@Override
	public String toString() {
		return "[" + employee.getEmp_no() + " " + title + " " + from_date.toString() + "]";
	}

}
