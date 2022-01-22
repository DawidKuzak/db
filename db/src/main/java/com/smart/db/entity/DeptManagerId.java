package com.smart.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class DeptManagerId implements Serializable {
	private Integer emp_no;
	private Character dept_no;
	private Date from_date;
	public DeptManagerId() {

	}
	public DeptManagerId(Integer employee, Character department, Date from_date) {
		super();
		this.emp_no = employee;
		this.dept_no = department;
		this.from_date = from_date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dept_no, emp_no, from_date);
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
		return Objects.equals(dept_no, other.dept_no) && Objects.equals(emp_no, other.emp_no)
				&& Objects.equals(from_date, other.from_date);
	}
}
