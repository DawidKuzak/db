package com.smart.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class TitleId implements Serializable {
	private Integer emp_no;
	
	private String title;

	private Date from_date;
	
	public TitleId() {
		// TODO Auto-generated constructor stub
	}

	public TitleId(Integer employee, String title, Date from_date) {
		super();
		this.emp_no = employee;
		this.title = title;
		this.from_date = from_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emp_no, from_date, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TitleId other = (TitleId) obj;
		return Objects.equals(emp_no, other.emp_no) && Objects.equals(from_date, other.from_date)
				&& Objects.equals(title, other.title);
	}
	
	
}
