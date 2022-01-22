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
@Table(name = "works_in")
@IdClass(WorksInId.class)
public class WorksIn {
	@Id
	@ManyToOne
    @JoinColumn(name = "emp_no", nullable = false)
    private Employee emp_no;

	@Id
	@ManyToOne
    @JoinColumn(name = "dept_no", nullable = false)
    private Department dept_no;
	
	private Date to_date;
	
	@Id
	private Date from_date;
	
	public WorksIn() {

	}

	public WorksIn(Employee employee, Department department, Date to_date, Date from_date) {
		super();
		this.emp_no = employee;
		this.dept_no = department;
		this.to_date = to_date;
		this.from_date = from_date;
	}

	public Employee getEmployee() {
		return emp_no;
	}

	public Department getDepartment() {
		return dept_no;
	}

	public Date getTo_date() {
		return to_date;
	}

	public Date getFrom_date() {
		return from_date;
	}

	@Override
	public String toString() {
		return "[" + dept_no.getId() + " " + emp_no.getEmp_no() + " " + from_date.toString() + " "
				+ to_date.toString() + "]";
	}
}
