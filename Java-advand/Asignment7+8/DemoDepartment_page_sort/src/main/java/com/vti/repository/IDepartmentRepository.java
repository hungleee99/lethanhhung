package com.vti.repository;

import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository{
	public List<Department> getAllDepartments(int page,int size,String sortType,String sortField,String search);
	public List<Department> getAllDepartments_search(String search);
	public Department getDepartmentByID(short id);
	public void createDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(short id);

}
