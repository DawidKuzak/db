package com.smart.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class DeptManagerId implements Serializable {
	private Employee employee;
	private Department department;
	private Date from_date;
	public DeptManagerId() {

	}
	public DeptManagerId(Employee employee, Department department, Date from_date) {
		super();
		this.employee = employee;
		this.department = department;
		this.from_date = from_date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(department, employee, from_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeptManagerId other = (DeptManagerId) obj;
		return Objects.equals(department, other.department) && Objects.equals(employee, other.employee)
				&& Objects.equals(from_date, other.from_date);
	}
}
