package com.smart.db.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dept_manager")
@IdClass(DeptManagerId.class)
public class DeptManager {
	@Id
	@ManyToOne
	@JoinColumn(name = "emp_no", nullable = false)
	private Employee employee;

	@Id
	@ManyToOne
	@JoinColumn(name = "dept_no", nullable = false)
	private Department department;

	private Date to_date;

	@Id
	private Date from_date;

	public DeptManager() {

	}

	public DeptManager(Employee employee, Department department, Date to_date, Date from_date) {
		super();
		this.employee = employee;
		this.department = department;
		this.to_date = to_date;
		this.from_date = from_date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Department getDepartment() {
		return department;
	}

	public Date getTo_date() {
		return to_date;
	}

	public Date getFrom_date() {
		return from_date;
	}

	@Override
	public String toString() {
		return "[" + department.getId() + " " + employee.getEmp_no() + " " + from_date.toString() + " "
				+ to_date.toString() + "]";
	}

}