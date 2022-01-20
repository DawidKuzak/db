package com.smart.db.entity;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@IdClass(SalaryId.class)
@Table(name = "salaries")
public class Salary {
	@Id
	@ManyToOne
	@JoinColumn(name = "emp_no", nullable = false)
	private Employee employee;

	@Size(max = 11)
	private Integer salary;

	@Id
	private Date from_date;

	public Salary() {

	}

	public Salary(Employee employee, @Size(max = 11) Integer salary, Date from_date) {
		super();
		this.employee = employee;
		this.salary = salary;
		this.from_date = from_date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Integer getSalary() {
		return salary;
	}

	public Date getFrom_date() {
		return from_date;
	}

	@Override
	public String toString() {
		return "[" + employee.getEmp_no() + " " + salary + " " + from_date.toString() + "]";
	}
}
