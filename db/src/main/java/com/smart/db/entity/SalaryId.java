package com.smart.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class SalaryId implements Serializable {
	private Employee employee;
	private Date from_date;
	public SalaryId() {

	}
	public SalaryId(Employee employee, Date from_date) {
		super();
		this.employee = employee;
		this.from_date = from_date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employee, from_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaryId other = (SalaryId) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(from_date, other.from_date);
	}
}
