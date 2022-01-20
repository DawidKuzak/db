package com.smart.db.entity;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class Department {
	@Id
	@Size(max = 4)
	private Character dept_no;

	@NotNull
	@Size(max = 50)
	private String dept_name;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private transient Set<WorksIn> works_ins;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private transient Set<DeptManager> dept_managers;

	public Department() {

	}

	public Department(@Size(max = 4) Character id, @NotNull @Size(max = 50) String dept_name) {
		super();
		this.dept_no = id;
		this.dept_name = dept_name;
	}

	public Character getId() {
		return dept_no;
	}

	public String getDept_name() {
		return dept_name;
	}

	public Set<DeptManager> getDeptManagers() {
		return dept_managers;
	}

	public Set<WorksIn> getWorks_ins() {
		return works_ins;
	}

	@Override
	public String toString() {
		return "[" + dept_no + " " + dept_name + "]";
	}
}