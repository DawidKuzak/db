package com.smart.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class SalaryId implements Serializable {
	private Integer emp_no;
	private Date from_date;
	public SalaryId() {

	}
	public SalaryId(Integer employee, Date from_date) {
		super();
		this.emp_no = employee;
		this.from_date = from_date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(emp_no, from_date);
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
		return Objects.equals(emp_no, other.emp_no) && Objects.equals(from_date, other.from_date);
	}
	
}
